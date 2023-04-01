package br.com.training.exampleAPIREST.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum EspecialidadeEnum {

    ORTOPEDIA(0,"MÉDICO ORTOPEDISTA"),
    CARDIOLOGIA(1,"MÉDICO CARDIOLOGISTA"),
    GINECOLOGIA(2,"MÉDICO GINECOLOGISTA"),
    DERMATOLOGIA(3,"MÉDICO DERMATOLOGIA");

    private Integer codigo;
    private String descricao;

    EspecialidadeEnum(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EspecialidadeEnum retornaEspecialidade(Integer codigo){
        if (codigo == null)
            return null;
        List<EspecialidadeEnum> collect = Arrays.stream(EspecialidadeEnum.values()).filter(e -> e.getCodigo().equals(codigo)).collect(Collectors.toList());
        if (collect.isEmpty())
            throw new IllegalArgumentException("Não existe a especificação médica com o código solicitado. Código = " + codigo);
        return collect.get(0);
    }
}
