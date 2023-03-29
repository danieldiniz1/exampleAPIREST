package br.com.training.exampleAPIREST.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "tb_endereco")
@Data
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    private String logradouro,numero,complemento,bairro,cidade,estado,cep;
    @ManyToOne()
    private MedicoModel medico;
    private Boolean isActive;


}
