package br.com.training.exampleAPIREST.model;

import lombok.Data;

@Data(staticConstructor = "valueOf")
public class StandartError {

    private String message, error, timeStamp;
}
