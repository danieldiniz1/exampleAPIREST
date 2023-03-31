package br.com.training.exampleAPIREST.facade.impl;

import br.com.training.exampleAPIREST.exception.UserExistsException;
import br.com.training.exampleAPIREST.facade.MedicoFacade;
import br.com.training.exampleAPIREST.model.MedicoModel;
import br.com.training.exampleAPIREST.model.dto.MedicoDTO;
import br.com.training.exampleAPIREST.model.record.MedicoRecord;
import br.com.training.exampleAPIREST.model.record.MedicoUpdateRecord;
import br.com.training.exampleAPIREST.populator.Populator;
import br.com.training.exampleAPIREST.service.EnderecoService;
import br.com.training.exampleAPIREST.service.MedicoService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class DefaultMedicoFacade implements MedicoFacade {

    private static final Logger LOGGER = LogManager.getLogger();
    private Populator<MedicoRecord, MedicoModel> medicoPopulator;
    private Populator<MedicoModel,MedicoDTO> medicoReversePopulator;
    private Populator<MedicoUpdateRecord,MedicoModel> medicoUpdatePopulator;
    private MedicoService medicoService;
    private EnderecoService enderecoService;

    @Override
    @Transactional
    public String criarNovoMedico(MedicoRecord record) {
        if (medicoService.buscarMedicoPorCrm(record.crm())){
            throw new UserExistsException("A doctor exists by crm: " + record.crm());
        }
        return medicoService.saveMedico(medicoConverter(record, MedicoModel.valueOf()));
    }

    @Override
    public Page<MedicoDTO> buscarTodosMedicos(Integer page, Integer linesPerPage, String orderBy, String direction) {
        Page<MedicoModel> pageable = medicoService.findAllMedicos(page,linesPerPage,verifyOrderBy(orderBy),direction);
        Page<MedicoDTO> medicoDTOS = pageable.map(medicoModel -> {
            MedicoDTO medicoDTO = MedicoDTO.valueOf();
            medicoReversePopulator.populate(medicoModel, medicoDTO);
            return medicoDTO;
        });
        return medicoDTOS;
    }

    @Transactional
    @Override
    public String atualizarMedico(MedicoUpdateRecord record) {
        MedicoModel medico = medicoService.findMedicoById(record.id());
        medicoConverterUpdate(medico,record);
        return medicoService.saveMedico(medico);
    }

    private void medicoConverterUpdate(MedicoModel medico, MedicoUpdateRecord record) {
        medicoUpdatePopulator.populate(record,medico);
    }

    private String verifyOrderBy(String orderBy) {
        if (orderBy.equals("nome") | orderBy.equals("email") | orderBy.equals("sobrenome"))
            return "dadosPessoais." + orderBy;
        return orderBy;
    }

    private MedicoModel medicoConverter(MedicoRecord record, MedicoModel model) {
        medicoPopulator.populate(record,model);
        setOutrosEnderecosComoNaoPrincipal(model);
        model.getEndereco().add(enderecoService.saveEndereco(record.endereco()));
        return model;
    }

    private void setOutrosEnderecosComoNaoPrincipal(MedicoModel model) {
        model.getEndereco().forEach(e -> e.setIsActive(false));
    }
}
