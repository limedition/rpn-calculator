package com.taku;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Calculator {

    private static final double DEFAULT_VALUE = Double.NaN;
    private final Deque<Double> numbersQueue = new LinkedList<>();

    Double calculate(String input) {
        try {
            return calculateLine(input);
        } catch (NoSuchElementException | NumberFormatException e) {
            numbersQueue.clear();
            System.out.println("Restore the default state on invalid input value.");
        }
        return DEFAULT_VALUE;
    }

    private Double calculateLine(String line) {
        Arrays.stream(line.trim().split(" ")).filter(t -> t.trim().length() > 0).forEach(token -> {
            Optional<Operation> operation = Operation.findByOperator(token);
            operation.ifPresent(this::execute);
            if (!operation.isPresent()) {
                numbersQueue.push(Double.parseDouble(token));
            }
        });
        return Optional.ofNullable(numbersQueue.peek()).orElse(DEFAULT_VALUE);
    }

    private void execute(Operation operation) {
        numbersQueue.push(operation.getFunction().apply(numbersQueue.pop(), numbersQueue.pop()));
    }
}
