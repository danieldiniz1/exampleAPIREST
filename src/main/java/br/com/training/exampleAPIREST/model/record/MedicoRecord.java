package br.com.training.exampleAPIREST.model.record;

public record MedicoRecord(String nome,
                           String sobrenome,
                           String email,
                           String crm,
                           int especialidade,
                           String telefone,
                           EnderecoRecord endereco) {
}
