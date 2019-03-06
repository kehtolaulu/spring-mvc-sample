package app.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.BinaryOperator;

@Component
@Qualifier("calculator")
public class Adder implements Calculator {
    private Map<String, BinaryOperator<Double>> stringToOperation = new TreeMap<>() {{
        put("+", (v1, v2) -> v1 + v2);
        put("-", (v1, v2) -> v1 - v2);
        put("/", (v1, v2) -> v1 / v2);
        put("*", (v1, v2) -> v1 * v2);
    }};

    public Number calculate(String operation, Double v1, Double v2) throws NoSuchMethodException {
        if (stringToOperation.containsKey(operation)) {
            return stringToOperation.get(operation).apply(v1, v2);
        } else {
            throw new NoSuchMethodException(String.format("%s not found", operation));
        }
    }
}
