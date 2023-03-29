package br.com.training.exampleAPIREST.service;

import br.com.training.exampleAPIREST.model.MedicoModel;
import br.com.training.exampleAPIREST.model.record.MedicoRecord;

public interface MedicoService {

    String saveMedico(MedicoModel record);

    boolean buscarMedicoPorCrm(String crm);
}
