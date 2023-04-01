package br.com.training.exampleAPIREST.exception;

public class UserExistsException extends RuntimeException {
    public UserExistsException(String s) {
        super(s);
    }
}
