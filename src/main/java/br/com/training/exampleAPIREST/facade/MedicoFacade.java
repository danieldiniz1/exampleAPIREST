package br.com.training.exampleAPIREST.facade;

import br.com.training.exampleAPIREST.model.dto.MedicoDTO;
import br.com.training.exampleAPIREST.model.record.MedicoRecord;
import br.com.training.exampleAPIREST.model.record.MedicoUpdateRecord;
import org.springframework.data.domain.Page;

public interface MedicoFacade {

    String criarNovoMedico(MedicoRecord record);
    Page<MedicoDTO> buscarTodosMedicos(Integer page, Integer linesPerPage, String orderBy, String direction);
    String atualizarMedico(MedicoUpdateRecord record);
}
