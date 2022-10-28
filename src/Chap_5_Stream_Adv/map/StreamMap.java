package Chap_5_Stream_Adv.map;

import Chap_5_Stream_Adv.sample_data.Dish;
import Chap_5_Stream_Adv.sample_data.SampleDishes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamMap {
    public static void main(String[] args) {
        List<Dish> dishes = SampleDishes.getDishes();

        List<Integer> collect = dishes.stream()
                .map(d -> d.getName().length())
                .collect(toList());

        for (int s : collect) {
            System.out.println("s = " + s);
        }

        List<String> strings = Arrays.asList("Haansel", "Hwang");

        List<String[]> splitsStrings = strings
                .stream()
                .map(s -> s.split(""))
                .distinct()
                .collect(toList());

        for (String[] splitsString : splitsStrings) {
            for (String singleOne : splitsString) {
                System.out.print(singleOne + " + ");
            }
            System.out.println();
        }


        System.out.println("##########################");

        List<String> collect1 = strings.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());

        for (String w : collect1) {
            System.out.println(w);
        }


        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect2 = integers.stream()
                .map(i -> i * i)
                .collect(toList());

        for (Integer integer : collect2) {
            System.out.println(integer);
        }
        System.out.println("######################");

        List<Integer> first = Arrays.asList(1, 2, 3);
        List<Integer> second = Arrays.asList(3, 4);

        List<int[]> ints = first
                .stream()
                .flatMap(f -> second.stream()
                        .filter(s -> (f+s) % 3 == 0)
                        .map(s -> new int[]{f, s}))
                .toList();

        for (int[] anInt : ints) {
            System.out.println(anInt[0] + " " + anInt[1]);
        }

    }
}
