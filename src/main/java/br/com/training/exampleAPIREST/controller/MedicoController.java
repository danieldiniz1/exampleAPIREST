package br.com.training.exampleAPIREST.controller;

import br.com.training.exampleAPIREST.facade.MedicoFacade;
import br.com.training.exampleAPIREST.model.dto.MedicoDTO;
import br.com.training.exampleAPIREST.model.record.MedicoRecord;
import br.com.training.exampleAPIREST.model.record.MedicoUpdateRecord;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/medicos")
@AllArgsConstructor
public class MedicoController {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String URL_BASE = "/medicos";
    private MedicoFacade medicoFacade;

    @PostMapping
    public ResponseEntity cadastrarMedico(@RequestBody MedicoRecord medicoRecord, UriComponentsBuilder uriBuilder){
        LOGGER.info(medicoRecord);
        String id = medicoFacade.criarNovoMedico(medicoRecord);
//        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri()).build();
        return ResponseEntity.created(uriBuilder.path(URL_BASE+"/{id}").buildAndExpand(id).toUri()).build();
    }

    @PatchMapping()
    public ResponseEntity atualizarMedico(@RequestBody @Valid MedicoUpdateRecord record){
        String id = medicoFacade.atualizarMedico(record);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirMedico(@PathVariable String id){
        LOGGER.info(String.format("O medico com id %s está com status de ativo como %s.",id,medicoFacade.excluirMedico(id)));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<Page<MedicoDTO>> buscarTodosMedicos(
            @RequestParam(value = "page",defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage",defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "orderBy",defaultValue = "crm") String orderBy,
            @RequestParam(value = "direction",defaultValue = "ASC") String direction){
        return ResponseEntity.status(200).body((medicoFacade.buscarTodosMedicos(page,linesPerPage,orderBy,direction)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> buscarMedicoPorId(@PathVariable String id){
        return ResponseEntity.ok(medicoFacade.buscarMedicoPorId(id));
    }
}
