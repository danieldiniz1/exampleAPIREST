package br.com.training.exampleAPIREST.service;

import br.com.training.exampleAPIREST.model.MedicoModel;
import org.springframework.data.domain.Page;

public interface MedicoService {

    String saveMedico(MedicoModel record);

    boolean buscarMedicoPorCrm(String crm);

    Page<MedicoModel> findAllMedicos(Integer page, Integer linesPerPage, String orderBy, String direction);

    MedicoModel findMedicoById(String id);
}
