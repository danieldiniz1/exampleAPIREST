package br.com.training.exampleAPIREST.controller;

import br.com.training.exampleAPIREST.facade.ConsultaFacade;
import br.com.training.exampleAPIREST.model.record.ConsultaRecord;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
@AllArgsConstructor
public class ConsultaController {

    private static final Logger LOGGER = LogManager.getLogger();
    private ConsultaFacade consultaFacade;

    @PostMapping
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity agendar(@RequestBody @Valid ConsultaRecord consultaRecord){
        LOGGER.info(consultaRecord);
        consultaFacade.agendarConsulta(consultaRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaFacade.agendarConsulta(consultaRecord));
    }

}
