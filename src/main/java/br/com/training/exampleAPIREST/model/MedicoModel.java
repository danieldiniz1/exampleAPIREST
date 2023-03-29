package br.com.training.exampleAPIREST.model;

import br.com.training.exampleAPIREST.model.enums.EspecialidadeEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_medicos")
@Data
public class MedicoModel {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    @Embedded
    private DadosPessoaisModel dadosPessoais;
    @OneToMany
    private List<EnderecoModel> endereco = new ArrayList<>();
    private String crm;
    private EspecialidadeEnum especialidade;

}
