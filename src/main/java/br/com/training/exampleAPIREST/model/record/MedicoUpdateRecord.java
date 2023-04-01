package br.com.training.exampleAPIREST.model.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicoUpdateRecord(
        @NotBlank
        String id,
        @NotNull
        String nome,
        @NotNull
        String sobrenome,
        @NotNull
        String email,
        @NotNull
        String telefone) {
}
