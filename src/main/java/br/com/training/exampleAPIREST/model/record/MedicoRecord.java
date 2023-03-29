package br.com.training.exampleAPIREST.model.record;

public record MedicoRecord(String nome,String email,String crm,int especialidade, EnderecoRecord endereco) {
}
