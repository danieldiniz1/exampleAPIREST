package br.com.training.exampleAPIREST.model.domain;

import lombok.Data;

@Data(staticConstructor = "valueOf")
public class StandartErrorModel {

    private String message, error, timeStamp;
}
