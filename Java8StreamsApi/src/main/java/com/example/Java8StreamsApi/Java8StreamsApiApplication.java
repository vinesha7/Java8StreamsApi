package com.example.Java8StreamsApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Java8StreamsApi.Predicates.IntegerPredicates;

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
		
	
		//Predicate<Type> p = condition
		//Predicate<Person> person = p -> p.getAge()
		List<Integer> numbers1 = Arrays.asList(12,23,56,4,-9);
		List<Integer> filtredNumbers = getFilteredNumbers(numbers1,IntegerPredicates.positiveIntergerPredicate);
		filtredNumbers.forEach(System.out::println);
		
		List<Integer> filtredNegativeNumbers = getFilteredNumbers(numbers1,IntegerPredicates.negativeIntergerPredicate);
		filtredNegativeNumbers.forEach(System.out::println);
		
		
		
		List<Person> persons = Arrays.asList(new Person("Anthony","Male"),new Person("Mark","Male"),new Person("Sue","Female"));
		Consumer<Person> consumer = new Consumer<Person>() {

			@Override
			public void accept(Person t) {

				if(t.getGender().equals("Male"))
					System.out.println("Mr "+t.getName());
				else
					System.out.println("Mrs "+t.getName());
			}
		};
		
		
		printPersonDetails(persons, consumer);
	
	}
	
	public static List<Integer> getFilteredNumbers(List<Integer> numbers , Predicate<Integer> integerPredicate){
		
		List<Integer> filteredNumbers = new ArrayList<Integer>();
		numbers.forEach(x->{
			if(integerPredicate.test(x))
				filteredNumbers.add(x);
			
		});
		
		/*for(Integer i : numbers) {
			if(integerPredicate.test(i)) {
				filteredNumbers.add(i);
			}*/
			
		//}
		
		return filteredNumbers;
		
	}
	
	public void printPersonDetails(List<Person> persons , Consumer consumer) {
		persons.forEach(p->consumer.accept(p));
	}
}
