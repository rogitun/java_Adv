package Chap_4_Stream;

import Chap_4_Stream.sample.Dish;
import Chap_4_Stream.sample.SampleDishes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class BeforeStream {

    public static void main(String[] args) {

        List<Dish> menu = SampleDishes.getDishes();


        //Not Use Stream
        List<Dish> lowCalories = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalory() < 400) {
                lowCalories.add(dish);
            }
        }
        Collections.sort(lowCalories, Comparator.comparingInt(d -> d.getCalory()));

        //USE Stream
        List<String> lowMenus = lowCalories
                .stream()
                .sorted(Comparator.comparingInt(d -> d.getCalory()))
                .filter(d -> d.getCalory() < 400)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());


        List<String> strings = menu
                .stream()
                .filter(m -> {
                    System.out.printf("Filtering " + m.getName());
                    return m.getCalory() > 300;
                })
                .map(dish -> {
                    System.out.println("Mapping " + dish.getName());
                    return dish.getName();
                })
                .toList();
    }
}
