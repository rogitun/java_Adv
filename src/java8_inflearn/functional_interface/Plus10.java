package java8_inflearn.functional_interface;

import java.util.function.Function;

public class Plus10 implements Function<Integer, String> {

	@Override
	public String apply(Integer integer) {
		return integer.toString();
	}
}
