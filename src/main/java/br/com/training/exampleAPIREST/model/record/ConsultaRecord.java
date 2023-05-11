package br.com.training.exampleAPIREST.model.record;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ConsultaRecord(String idMedico,
                             @NotNull String idPaciente,
                             @NotNull @Future LocalDateTime data) {
}
