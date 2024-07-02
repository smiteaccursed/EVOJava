package com.example.demo;
import org.springframework.stereotype.Component;

@Component("add")
public class Adder implements Operation {
    @Override
    public double getResult(double a, double b) {
        return a + b;
    }

    @Override
    public String toString() {
        return "сложение";
    }
}

