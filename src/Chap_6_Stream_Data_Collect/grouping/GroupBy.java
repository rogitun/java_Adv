package Chap_6_Stream_Data_Collect.grouping;

import Chap_6_Stream_Data_Collect.sample_data.Dish;
import Chap_6_Stream_Data_Collect.sample_data.SampleDishes;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.collectingAndThen;

public class GroupBy {
    public static void main(String[] args) {
        List<Dish> dishes = SampleDishes.getDishes();
        groupingByCounting(dishes);

        System.out.println("#CollectingAndThen");
        collectingAndThen(dishes);

        System.out.println("#PartitionBy");
        divideGroup(dishes);
    }

    public static void divideGroup(List<Dish> dishes) {
        Map<Boolean, List<Dish>> collect = dishes.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        collect.entrySet().forEach(e -> {
                    System.out.println(e.getKey() + " " + e.getValue());
                }
        );

        Map<Boolean, Map<Dish.Type, List<Dish>>> collect2 = dishes.stream().collect(
                Collectors.partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));

        collect.entrySet().forEach(e -> {
                    System.out.println(e.getKey() + " " + e.getValue());
                }
        );

        Map<Boolean, List<Dish>> collect1 = dishes.stream().collect(
                groupingBy(Dish::isVegetarian));

        collect1.entrySet().forEach(e -> {
            System.out.println(e.getKey() + " "+ e.getValue());
        });

        Map<Boolean, Map<Dish.Type, List<Dish>>> collect3 = dishes.stream().collect(
                groupingBy(Dish::isVegetarian, groupingBy(Dish::getType)));

        collect2.entrySet().forEach(e -> {
            System.out.println(e.getKey() + " " + e.getValue());
        });

        collect3.entrySet().forEach(e -> {
            System.out.println(e.getKey() + " " + e.getValue());
        });
    }

    public static void collectingAndThen(List<Dish> dishes) {
        Map<Dish.Type, Dish> collect = dishes.stream().collect(
                groupingBy(Dish::getType,
                        Collectors.collectingAndThen(
                                maxBy(comparingInt(Dish::getCalory)), Optional::get)));

        collect.entrySet().forEach(e -> {
            System.out.println(e.getKey() + " " + e.getValue());
        });
    }

    public static void groupingByCounting(List<Dish> dishes) {
        Map<Dish.Type, Long> collect = dishes.stream().collect(
                groupingBy(Dish::getType, Collectors.counting()));

        collect.entrySet().forEach(
                e -> {
                    System.out.println(e.getKey() + " " + e.getValue());
                }
        );
    }

    public void group1(List<Dish> dishes) {

        //dish의 타입으로 1차 그루핑 후 칼로리가 300이 넘는지 넘지 않는지에 대해 2차 그루핑

        Map<Dish.Type, Map<String, List<Dish>>> collect = dishes.stream()
                .collect(
                        groupingBy(Dish::getType,
                                groupingBy(dish -> {
                                    if (dish.getCalory() > 300) {
                                        return "Heavy";
                                    } else {
                                        return "DIET";
                                    }
                                }))
                );

        Set<Map.Entry<Dish.Type, Map<String, List<Dish>>>> entries = collect.entrySet();
        entries.forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
    }

}
