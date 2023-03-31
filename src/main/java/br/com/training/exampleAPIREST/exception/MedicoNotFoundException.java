package br.com.training.exampleAPIREST.exception;

public class MedicoNotFoundException extends RuntimeException {
    public MedicoNotFoundException(String s) {
        super(s);
    }
}
