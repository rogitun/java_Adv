package java8_inflearn.functional_interface;

import java.util.Objects;
import java.util.function.Function;

public class Foo {
	public static void main(String[] args) {

		RunSomething runSomething = (num) -> {
			System.out.println("the input number is " + num);
		};
		runSomething.doIt(10);

		Plus10 plus10 = new Plus10();
		String apply = plus10.apply(10);
		System.out.println(apply.getClass().equals(String.class));

		Function<Integer, String> function = (num) -> num.toString();

		System.out.println(function.apply(55).getClass().equals(String.class));

		Function<Integer, Integer> plus = (i) -> i + 1;
		Function<Integer, Integer> multi = (i) -> i * 2;

		// Integer val = plus.compose(multi).apply(5);
		// System.out.println(val);

		Integer apply1 = plus.andThen(multi).apply(5);
		System.out.println(apply1.compareTo(12));
	}
}
