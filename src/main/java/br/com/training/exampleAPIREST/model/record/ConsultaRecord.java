package br.com.training.exampleAPIREST.model.record;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ConsultaRecord(String idMedico,
                             @NotNull String idPaciente,
                             @NotNull
                             @Future
                             @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                             @JsonAlias({"data_consulta","horario"}) LocalDateTime data) {
}
