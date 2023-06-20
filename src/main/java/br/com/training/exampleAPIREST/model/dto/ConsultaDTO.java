package br.com.training.exampleAPIREST.model.dto;

import lombok.Data;

@Data
public class ConsultaDTO {

    private String data;

    public static ConsultaDTO valueOf(String data){
        ConsultaDTO consultaDTO = new ConsultaDTO();
        consultaDTO.setData(data);
        return consultaDTO;
    }
}
