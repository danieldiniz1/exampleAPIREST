package br.com.training.exampleAPIREST.facade;

import br.com.training.exampleAPIREST.model.dto.ConsultaDTO;
import br.com.training.exampleAPIREST.model.record.ConsultaRecord;

public interface ConsultaFacade {

    ConsultaDTO agendarConsulta(ConsultaRecord dadosConsulta);
}
