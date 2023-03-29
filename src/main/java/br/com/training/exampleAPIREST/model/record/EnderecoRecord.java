package br.com.training.exampleAPIREST.model.record;

public record EnderecoRecord(String logradouro,
                             String bairro,
                             String cep,
                             String cidade,
                             String uf,
                             String numero,
                             String complemento,
                             boolean atual) {
}
