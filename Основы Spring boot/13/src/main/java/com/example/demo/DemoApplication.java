package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private Calculator calculator;

	@Bean
	public boolean outToConsole() throws Exception {
		Scanner in = new Scanner(System.in);

		System.out.print("Введите число a\n> ");
		double a = in.nextDouble();
		System.out.print("Введите число b\n> ");
		double b = in.nextDouble();
		System.out.print("Введите тип операции:" + calculator.getSupportedOperations() + "\n> ");
		String operationType = in.next();

		calculator.calc(operationType, a, b);
		return true;
	}
}