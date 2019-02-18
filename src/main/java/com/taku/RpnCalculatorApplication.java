package com.taku;

import com.taku.io.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RpnCalculatorApplication implements CommandLineRunner {

    private static final String EXIT_CMD = "q";
    private final Calculator calculator;
    private final Client client;

    public RpnCalculatorApplication(Calculator calculator, Client client) {
        this.calculator = calculator;
        this.client = client;
    }

    public static void main(String[] args) {
        SpringApplication.run(RpnCalculatorApplication.class, args);
    }

    @Override
    public void run(String... args) {
        client.getOutput().accept("Command-line reverse polish notation calculator\n> ");
        for (String line = client.getInput().get(); !line.contains(EXIT_CMD); line = client.getInput().get()) {
            client.getOutput().accept(calculator.calculate(line));
            client.getOutput().accept("\n> ");
        }
    }

}
