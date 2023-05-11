package br.com.training.exampleAPIREST.model.dto;

import lombok.Data;

@Data
public class ConsultaDTO {

    private String id, idMedico, idPaciente, data;
}
