package com.etiya.core.logging;

public class ConsoleLogger implements Logger{
    @Override
    public void log(String data) {
        System.out.println("Logged into console: " + data);
    }
}
