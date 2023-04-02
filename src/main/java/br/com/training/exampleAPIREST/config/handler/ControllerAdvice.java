package br.com.training.exampleAPIREST.config.handler;

import br.com.training.exampleAPIREST.exception.ConversionPopulatorException;
import br.com.training.exampleAPIREST.exception.MedicoNotFoundException;
import br.com.training.exampleAPIREST.exception.UserExistsException;
import br.com.training.exampleAPIREST.model.StandartError;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MedicoNotFoundException.class)
    public ResponseEntity<StandartError> medicoNotFound(MedicoNotFoundException ex){
        return ResponseEntity.status(404).body(populateError(ex));
    }

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<StandartError> medicoExists(UserExistsException ex){
        return ResponseEntity.status(404).body(populateError(ex));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandartError> NotFound(EntityNotFoundException ex){
        return ResponseEntity.status(404).body(populateError(ex));
    }

    @ExceptionHandler(ConversionPopulatorException.class)
    public ResponseEntity<StandartError> ConversionNotPossible(ConversionPopulatorException ex){
        return ResponseEntity.status(400).body(populateError(ex));
    }

    private StandartError populateError(Exception ex) {
        StandartError standartError = StandartError.valueOf();
        standartError.setError(standartError.getError());
        standartError.setMessage(ex.getMessage());
        standartError.setTimeStamp(LocalDateTime.now().toString());
        return standartError;
    }
}
