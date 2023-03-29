package br.com.training.exampleAPIREST.facade.impl;

import br.com.training.exampleAPIREST.exception.UserExistsException;
import br.com.training.exampleAPIREST.facade.MedicoFacade;
import br.com.training.exampleAPIREST.model.MedicoModel;
import br.com.training.exampleAPIREST.model.record.MedicoRecord;
import br.com.training.exampleAPIREST.populator.Populator;
import br.com.training.exampleAPIREST.service.MedicoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DefaultMedicoFacade implements MedicoFacade {

    private Populator<MedicoRecord, MedicoModel> medicoPopulator;
    private MedicoService medicoService;

    @Override
    public String criarNovoMedico(MedicoRecord record) {
        if (medicoService.buscarMedicoPorCrm(record.crm())){
            throw new UserExistsException("A doctor exists by crm: " + record.crm());
        }
        return medicoService.saveMedico(medicoConverter(record, MedicoModel.valueOf()));
    }

    private MedicoModel medicoConverter(MedicoRecord record, MedicoModel model) {
        medicoPopulator.populate(record,model);
        return model;
    }
}
