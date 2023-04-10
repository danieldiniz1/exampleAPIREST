package br.com.training.exampleAPIREST.exception;

public class TokenException extends RuntimeException {
    public TokenException(String message) {
        super(message);
    }
}
