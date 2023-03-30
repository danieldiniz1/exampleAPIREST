package br.com.training.exampleAPIREST.facade.impl;

import br.com.training.exampleAPIREST.exception.UserExistsException;
import br.com.training.exampleAPIREST.facade.MedicoFacade;
import br.com.training.exampleAPIREST.model.EnderecoModel;
import br.com.training.exampleAPIREST.model.MedicoModel;
import br.com.training.exampleAPIREST.model.record.EnderecoRecord;
import br.com.training.exampleAPIREST.model.record.MedicoRecord;
import br.com.training.exampleAPIREST.populator.Populator;
import br.com.training.exampleAPIREST.service.EnderecoService;
import br.com.training.exampleAPIREST.service.MedicoService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class DefaultMedicoFacade implements MedicoFacade {

    private static final Logger LOGGER = LogManager.getLogger();
    private Populator<MedicoRecord, MedicoModel> medicoPopulator;
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
