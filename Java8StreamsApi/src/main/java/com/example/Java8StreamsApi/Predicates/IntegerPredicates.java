package com.example.Java8StreamsApi.Predicates;

import java.util.function.Predicate;

public class IntegerPredicates {
	//Predicate<Person> person = p -> p.getAge()
	public static Predicate<Integer> positiveIntergerPredicate = new Predicate<Integer>() {

		@Override
		public boolean test(Integer i) {
			return i>0;
		}
		
	};
	
	
	public static Predicate<Integer> negativeIntergerPredicate = x->x<0;

}
