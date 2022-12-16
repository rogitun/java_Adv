package Chap_5_Stream_Adv.NumberStream;

import Chap_5_Stream_Adv.sample_data.Dish;
import Chap_5_Stream_Adv.sample_data.SampleDishes;

import java.util.List;

public class NumberStream {
    public static void main(String[] args) {
        List<Dish> dishes = SampleDishes.getDishes();

        //칼로리를 구해보자.

        int sum = dishes.stream()
                .mapToInt(d -> d.getCalory())
                .sum();
        //이외에도 max, min, average 등의 메서드가 존재한다.

        System.out.println(sum);


        dishes.
                stream()
                .toList();
    }
}
