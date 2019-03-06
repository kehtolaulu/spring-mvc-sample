package app.services;

public interface Calculator {
    Number calculate(String operation, Double v1, Double v2) throws NoSuchMethodException;
}
