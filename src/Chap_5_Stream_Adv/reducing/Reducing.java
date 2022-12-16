package Chap_5_Stream_Adv.reducing;

import Chap_5_Stream_Adv.sample_data.Dish;
import Chap_5_Stream_Adv.sample_data.SampleDishes;

import java.util.Arrays;
import java.util.List;

public class Reducing {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        Integer result = integers.stream()
                .reduce(0, (a, b) -> a + b);

        Integer result2Multi = integers.stream().reduce(1, (a, b) -> a * b);

        System.out.println(result);
        System.out.println(result2Multi);

        Integer max = integers.stream().reduce(0, (a, b) -> (a > b ? a : b));
        Integer min = integers.stream().reduce(Integer.MAX_VALUE, (a, b) -> (a > b ? b : a));
        System.out.println(max);
        System.out.println(min);

        List<Dish> dishes = SampleDishes.getDishes();

        Integer howmany = dishes.stream()
                .map(v -> v.isVegetarian() ? 1 : 0)
                .reduce(0, (f, s) -> f + s);

        System.out.println(howmany);


    }
}
