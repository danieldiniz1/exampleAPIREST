package br.com.training.exampleAPIREST.exception;

public class ModelNotFoundException extends RuntimeException {
    public ModelNotFoundException(String s) {
        super(s);
    }
}
