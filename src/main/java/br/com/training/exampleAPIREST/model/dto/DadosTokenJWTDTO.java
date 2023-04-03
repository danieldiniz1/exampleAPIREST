package br.com.training.exampleAPIREST.model.dto;

import lombok.Data;

@Data
public class DadosTokenJWTDTO {


    private static String tokenType = "";
    private String token;


    public static DadosTokenJWTDTO valueOf(String tokenJWT){
        var dadosTokenJWT = new DadosTokenJWTDTO();
        dadosTokenJWT.setToken(tokenType + tokenJWT);
        return dadosTokenJWT;
    }
}
