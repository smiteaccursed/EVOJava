package com.example.demo;
import org.springframework.stereotype.Component;

@Component("sub")
public class Subtractor implements Operation {
    @Override
    public double getResult(double a, double b) {
        return a - b;
    }

    @Override
    public String toString() {
        return "вычитание";
    }
}

