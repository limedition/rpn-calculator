package com.taku.io;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface Client {

    Supplier<String> getInput();

    Consumer<Object> getOutput();
}
