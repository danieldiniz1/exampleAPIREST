package br.com.training.exampleAPIREST.model.dto;

import lombok.Data;

@Data
public class CepDto {

    private String cep, logradouro, complemento, bairro, localidade, uf, ibge, gia, ddd, siafi;
}
