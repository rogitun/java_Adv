package a_java00;

import java.util.function.Function;

public class FunctionalInterFace {
    public static void main(String[] args) {
        // function Type

        //Integer를 String 타입으로
        Function<String,Integer> toInt = s -> Integer.parseInt(s);


        Integer apply = toInt.apply("5");
        System.out.println(apply);

        Function<Integer,Integer> identity = Function.identity();

        System.out.println(identity.apply(55));
    }
}
