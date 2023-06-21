package br.com.training.exampleAPIREST.model.domain;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data(staticConstructor = "valueOf")
public class DadosPessoaisModel {

    private String nome, sobrenome, email, telefone;
}
