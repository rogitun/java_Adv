package Chap_5_Stream_Adv.filter;

import Chap_5_Stream_Adv.sample_data.Dish;
import Chap_5_Stream_Adv.sample_data.SampleDishes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter {
    public static void main(String[] args) {
        List<Dish> veget = new ArrayList<>();
        List<Dish> menu = SampleDishes.getDishes();

        for (Dish dish : menu) {
            if (dish.isVegetarian()) {
                veget.add(dish);
            }
        }

        // -> Stream 변환

        // predicate 필터링. (불리언을 반환하는 함수)
        menu.stream()
                .filter(Dish::isVegetarian)
                .map(veget::add);
        for (Dish dish : veget) {
            System.out.println(dish);
        }


        //고유 요소 필터링
        List<Integer> integers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

        List<Integer> collect = integers.stream()
                .filter(num -> num % 2 == 0)
                .distinct()
                .collect(Collectors.toList());

        for (Integer integer : collect) {
            System.out.println(integer);
        }
    }
}
