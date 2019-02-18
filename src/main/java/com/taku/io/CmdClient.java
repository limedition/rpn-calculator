package com.taku.io;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Service
@Primary
public class CmdClient implements Client {

    private final Scanner cmd = new Scanner(System.in);

    private final Supplier<String> input = cmd::nextLine;

    private final Consumer<Object> output = System.out::print;

    @Override
    public Supplier<String> getInput() {
        return (cmd.hasNextLine()) ? input : () -> "q";
    }

    @Override
    public Consumer<Object> getOutput() {
        return output;
    }
}
