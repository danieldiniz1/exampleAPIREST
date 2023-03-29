package br.com.training.exampleAPIREST.facade;

import br.com.training.exampleAPIREST.model.record.MedicoRecord;

public interface MedicoFacade {

    String criarNovoMedico(MedicoRecord record);
}
