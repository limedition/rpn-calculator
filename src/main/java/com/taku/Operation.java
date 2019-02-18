package com.taku;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum Operation {
    SUM("+", (n1, n2) -> n2 + n1),
    SUBTRACT("-", (n1, n2) -> n2 - n1),
    DIVIDE("/", (n1, n2) -> n2 / n1),
    MULTIPLY("*", (n1, n2) -> n2 * n1);

    private final String operator;

    private final BiFunction<Double, Double, Double> function;

    Operation(String operator, BiFunction<Double, Double, Double> function) {
        this.operator = operator;
        this.function = function;
    }

    public static Optional<Operation> findByOperator(String operatorToken) {
        return Stream.of(Operation.values())
                .filter(op -> op.operator.equalsIgnoreCase(operatorToken))
                .findFirst();
    }

    public BiFunction<Double, Double, Double> getFunction() {
        return function;
    }

}
