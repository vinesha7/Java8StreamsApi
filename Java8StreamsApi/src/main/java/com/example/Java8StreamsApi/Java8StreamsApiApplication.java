package com.example.Java8StreamsApi;

import java.util.IntSummaryStatistics;
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

		//getAsInt can  throw exceptions if null 
		//Hence using IfPresent
		IntStream.of(numbers).min().ifPresent(min->System.out.println(min));
		//Using method reference System.out::println
		IntStream.of(numbers).min().ifPresent(System.out::println);
		
		long count = IntStream.of(numbers).count();
		
		System.out.println("count : "+count);
		
		System.out.println("Average : ");
		IntStream.of(numbers).average().ifPresent(System.out::println);
		
		
		IntSummaryStatistics stats = IntStream.of(numbers).summaryStatistics();
		
		System.out.println("stats : "+stats.getMax());
		
		System.out.println("first 3 smallest : ");
		
		IntStream.of(numbers).distinct().sorted().limit(3).forEach(System.out::print);
		
		//Create       Process Consume
		//Instream     Filters Output (print or sum)
		
		System.out.println("Sum of 3 even numbers : "+IntStream.range(0, 100).filter(x->x%2==0).limit(3).sum());
		
		System.out.println("AnyMAtch Odd: "+IntStream.range(0, 100).allMatch(x->x%2==1));
		
		System.out.println("findSum: "+IntStream.range(0, 10).filter(x->(x%3==0||x%5==0)).sum());
		
	
		
	}
}
