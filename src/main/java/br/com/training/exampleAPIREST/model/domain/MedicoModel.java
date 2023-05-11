package br.com.training.exampleAPIREST.model.domain;

import br.com.training.exampleAPIREST.model.enums.EspecialidadeEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;


@Data(staticConstructor = "valueOf")
@EqualsAndHashCode(of = "uuid")
@Entity(name = "tb_medicos")
public class MedicoModel {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    @Embedded
    private DadosPessoaisModel dadosPessoais;
    @OneToMany
    private List<EnderecoModel> endereco = new ArrayList<>();
    private String crm;
    private EspecialidadeEnum especialidade;
    private Boolean estaAtivo = Boolean.TRUE;

}
