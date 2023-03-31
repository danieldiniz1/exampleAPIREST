package br.com.training.exampleAPIREST.controller;

import br.com.training.exampleAPIREST.facade.MedicoFacade;
import br.com.training.exampleAPIREST.model.dto.MedicoDTO;
import br.com.training.exampleAPIREST.model.record.MedicoRecord;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/medicos")
@AllArgsConstructor
public class MedicoController {

    private static final Logger LOGGER = LogManager.getLogger();
    private MedicoFacade medicoFacade;

    @PostMapping
    public ResponseEntity cadastrarMedico(@RequestBody MedicoRecord medicoRecord){
        LOGGER.info(medicoRecord);
        String id = medicoFacade.criarNovoMedico(medicoRecord);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri()).build();
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<MedicoDTO>> buscarTodosMedicos(
            @RequestParam(value = "page",defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage",defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "orderBy",defaultValue = "crm") String orderBy,
            @RequestParam(value = "direction",defaultValue = "ASC") String direction){
        return ResponseEntity.status(200).body((medicoFacade.buscarTodosMedicos(page,linesPerPage,orderBy,direction)));
    }
}
