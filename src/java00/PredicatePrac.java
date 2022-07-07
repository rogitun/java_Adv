package java00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicatePrac {
    public static void main(String[] args) {


        Predicate<Integer> isPositive = i -> i > 0;

        System.out.println(isPositive.test(1));
        System.out.println(isPositive.test(-1));

        List<Integer> numbers = Arrays.asList(1,2,-2,3,-3,4,5);

        System.out.println(filter(numbers,isPositive));

    }

    private static <T> List<T> filter(List<T> list, Predicate<T> filter){
        List<T> result = new ArrayList<>();
        for(T input : list){
            if(filter.test(input))
                result.add(input);
        }
        return result;
    }
}
