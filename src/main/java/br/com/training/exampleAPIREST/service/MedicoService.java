package br.com.training.exampleAPIREST.service;

import br.com.training.exampleAPIREST.model.domain.MedicoModel;
import org.springframework.data.domain.Page;

public interface MedicoService {

    String saveMedico(MedicoModel medicoModel);

    boolean buscarMedicoPorCrm(String crm);

    Page<MedicoModel> findAllMedicos(Integer page, Integer linesPerPage, String orderBy, String direction);

    MedicoModel findMedicoById(String id);

    Page<MedicoModel> findAllMedicosAtivos(Integer page, Integer linesPerPage, String verifyOrderBy, String direction);

    MedicoModel buscarMedicoDisponivel();
}
