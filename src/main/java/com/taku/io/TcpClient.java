package com.taku.io;

import org.springframework.stereotype.Service;

import java.util.function.Consumer;
import java.util.function.Supplier;

@Service
public class TcpClient implements Client {

    @Override
    public Supplier<String> getInput() {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public Consumer<Object> getOutput() {
        throw new RuntimeException("Not implemented!");
    }
}
