package lambda.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hansel");
        list.add("hansel2");
        list.add("hansel3");


        func(list,(s)-> s.length());


        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        list2.add("3");

        list2.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String a = "123";

        Function<String, Integer> integerBiFunction = Integer::parseInt;



    }

    public static <T,R> void func(List<T> list, Function<T,R> f){
        List<R> result = new ArrayList<>();
        list.forEach(l -> result.add(f.apply(l)));

        for (R r : result) {
            System.out.println(r);
        }
    }

    public static <T,R> void func2(List<T> list, Function<T,R> f){

    }
}
