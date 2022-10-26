package Chap_5_Stream_Adv.filter;

import Chap_5_Stream_Adv.sample_data.Dish;
import Chap_5_Stream_Adv.sample_data.SampleDishes;

import java.util.List;

public class TakeWhile {
    public static void main(String[] args) {
        List<Dish> dishes = SampleDishes.getDishes();

        dishes.stream()
                .takeWhile(dish -> dish.getCalory() < 300)
                .forEach(System.out::println);
    }
}
