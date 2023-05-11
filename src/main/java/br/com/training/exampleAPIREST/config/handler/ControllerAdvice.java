package br.com.training.exampleAPIREST.config.handler;

import br.com.training.exampleAPIREST.exception.*;
import br.com.training.exampleAPIREST.model.domain.StandartErrorModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MedicoNotFoundException.class)
    public ResponseEntity<StandartErrorModel> medicoNotFound(MedicoNotFoundException ex){
        return ResponseEntity.status(404).body(populateError(ex));
    }

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<StandartErrorModel> medicoExists(UserExistsException ex){
        return ResponseEntity.status(404).body(populateError(ex));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandartErrorModel> NotFound(EntityNotFoundException ex){
        return ResponseEntity.status(404).body(populateError(ex));
    }

    @ExceptionHandler(ConversionPopulatorException.class)
    public ResponseEntity<StandartErrorModel> ConversionNotPossible(ConversionPopulatorException ex){
        return ResponseEntity.status(400).body(populateError(ex));
    }

    @ExceptionHandler(TokenException.class)
    public ResponseEntity<StandartErrorModel> TokenError(TokenException ex){
        return ResponseEntity.status(404).body(populateError(ex));
    }

    @ExceptionHandler(ConsultaException.class)
    public ResponseEntity<StandartErrorModel> consultaException(ConsultaException ex){
        return ResponseEntity.status(400).body(populateError(ex));
    }

    private StandartErrorModel populateError(Exception ex) {
        StandartErrorModel standartError = StandartErrorModel.valueOf();
        standartError.setError(standartError.getError());
        standartError.setMessage(ex.getMessage());
        standartError.setTimeStamp(LocalDateTime.now().toString());
        return standartError;
    }
}
