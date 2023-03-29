package br.com.training.exampleAPIREST.controller;

import br.com.training.exampleAPIREST.facade.MedicoFacade;
import br.com.training.exampleAPIREST.model.record.MedicoRecord;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
@AllArgsConstructor
public class MedicoController {

    private static final Logger LOGGER = LogManager.getLogger();
    private MedicoFacade medicoFacade;

    @PostMapping
    public ResponseEntity cadastrarMedico(@RequestBody MedicoRecord medicoRecord){
        LOGGER.info(medicoRecord);
        return ResponseEntity.status(200).body(medicoFacade.criarNovoMedico(medicoRecord));
    }
}
