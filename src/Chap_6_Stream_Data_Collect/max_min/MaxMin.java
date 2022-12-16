package Chap_6_Stream_Data_Collect.max_min;

import Chap_6_Stream_Data_Collect.sample_data.Dish;
import Chap_6_Stream_Data_Collect.sample_data.SampleDishes;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MaxMin {
    public static void main(String[] args) {
        List<Dish> dishes = SampleDishes.getDishes();

        Optional<Dish> collect = dishes.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalory)));
        Optional<Dish> collect2 = dishes.stream().collect(Collectors.minBy(Comparator.comparing(Dish::getCalory)));

        if(collect.isPresent()){
            System.out.println(collect.get());
        }

        if(collect2.isPresent()){
            System.out.println(collect2.get());
        }
    }
}
