package br.com.training.exampleAPIREST.model.dto;

import lombok.Data;

@Data(staticConstructor = "valueOf")
public class MedicoDTO {

    private String nome, sobrenome, email, crm, especialidade;


}
