package br.com.training.exampleAPIREST.populator;

public interface Populator<SOURCE,TARGET> {

    void populate(SOURCE source,TARGET target);
}
