package br.com.training.exampleAPIREST.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data(staticConstructor = "valueOf")
@EqualsAndHashCode(of = "uuid")
@Entity(name = "tb_endereco")
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    private String logradouro,numero,complemento,bairro,cidade,estado,cep;
    private Boolean isActive;


}
