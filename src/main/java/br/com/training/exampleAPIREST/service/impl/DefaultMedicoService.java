package br.com.training.exampleAPIREST.service.impl;

import br.com.training.exampleAPIREST.model.MedicoModel;
import br.com.training.exampleAPIREST.model.record.MedicoRecord;
import br.com.training.exampleAPIREST.repository.MedicoRepository;
import br.com.training.exampleAPIREST.service.MedicoService;
import br.com.training.exampleAPIREST.populator.Populator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultMedicoService implements MedicoService {

    private MedicoRepository medicoRepository;

    @Override
    public String saveMedico(MedicoModel model) {
        return medicoRepository.save(model).getUuid();
    }

    @Override
    public boolean buscarMedicoPorCrm(String crm) {
        return medicoRepository.findByCrm(crm).isPresent();
    }
}
