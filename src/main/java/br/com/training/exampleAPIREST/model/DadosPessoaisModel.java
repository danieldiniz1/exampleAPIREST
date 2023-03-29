package br.com.training.exampleAPIREST.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data(staticConstructor = "valueOf")
public class DadosPessoaisModel {

    private String nome, sobrenome, email, telefone;
}
