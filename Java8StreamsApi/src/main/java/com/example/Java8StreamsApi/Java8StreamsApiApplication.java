package com.example.Java8StreamsApi;

import java.util.stream.IntStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Java8StreamsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Java8StreamsApiApplication.class, args);
		Java8StreamsApiApplication java8StreamsApiApplication = new Java8StreamsApiApplication();
		java8StreamsApiApplication.myMethod();  
	}

	private void myMethod() {
		
		int[] numbers = {12,23,56,4,-9};
		
		int minimum = IntStream.of(numbers).min().getAsInt();
		
		System.out.println("minimum : "+minimum);
	}
}
