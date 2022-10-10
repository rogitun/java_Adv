package lambda.constructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ConsMain {
    public static void main(String[] args) {


        List<Integer> weights = Arrays.asList(1, 5, 7, 2, 99);

//        List<Apple> apples = toApple(weights,Apple::new);
//
//        for (Apple apple : apples) {
//            System.out.println(apple.toString());
//        }

        List<NotRipedApple> notRipedApples = new ArrayList<>();
        notRipedApples.add(new NotRipedApple(1, "fo"));
        notRipedApples.add(new NotRipedApple(5, "to"));
        notRipedApples.add(new NotRipedApple(2, "no"));
        notRipedApples.add(new NotRipedApple(99, "yo"));

        List<Apple> apples = toAppleBiFunction(notRipedApples, Apple::new);

        for (Apple apple : apples) {
            System.out.println(apple.toString());
        }


    }

    public static class NotRipedApple {
        int weight;
        String color;

        public NotRipedApple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }
    }

    public static <T, Apple> List<Apple> toApple(List<T> weights, Function<T, Apple> function) {
        List<Apple> apples = new ArrayList<>();
        for (T weight : weights) {
            apples.add(function.apply(weight));
        }
        return apples;
    }

    public static <T, R, Apple> List<lambda.constructor.Apple> toAppleBiFunction(List<NotRipedApple> weired, BiFunction<Integer, String, lambda.constructor.Apple> function) {
        List<lambda.constructor.Apple> apples = new ArrayList<>();

        for (NotRipedApple t : weired) {
            apples.add(function.apply(t.weight, t.color));
        }

        return apples;
    }
}
