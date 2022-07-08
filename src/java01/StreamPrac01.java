package java01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class StreamPrac01 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println(map1(numbers, i -> i*i));


        System.out.println(map(numbers, i -> i));

    }


    private static <T,R> List<R> map1(List<T> list, Function<T,R> mapper){
        final List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(mapper.apply(t));
        }
        return result;
    }

    private static <T,R> List<R> map(final List<T> list, final Function<T,R> mapper){
        final List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(mapper.apply(t));
        }
        return result;
    }

}
