package Chap_6_Stream_Data_Collect.summing;

import Chap_6_Stream_Data_Collect.sample_data.Dish;
import Chap_6_Stream_Data_Collect.sample_data.SampleDishes;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Summing {
    public static void main(String[] args) {
        List<Dish> dishes = SampleDishes.getDishes();

        Integer collect = dishes.stream().collect(Collectors.summingInt(Dish::getCalory));
        System.out.println(collect);

//        List<Dish> zeroCaloryDishes = SampleDishes.getZeroCaloryDishes();
//        Integer isZero = zeroCaloryDishes.stream()
//                .collect(Collectors.summingInt(Dish::getCalory));


        IntSummaryStatistics collect1 = dishes.stream()
                .collect(Collectors.summarizingInt(Dish::getCalory));

        System.out.println(collect1);


        Integer sum1 = dishes.stream().map(Dish::getCalory).reduce(0, Integer::sum);



    }
}
