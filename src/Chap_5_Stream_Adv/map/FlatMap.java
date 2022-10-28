package Chap_5_Stream_Adv.map;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Haansel", "Hwang");

        List<String[]> collect = strings.stream()
                .map(s -> s.split(""))
                .collect(Collectors.toList());

        for (String[] strings1 : collect) {
            System.out.println("OUTER");
            for (String s : strings1) {
                System.out.println("INNER = " + s);
            }
        }


        String a = "Hanse";
        String[] split = a.split("");


        String[][] namesArray = new String[][]{
                {"kim", "taeng"}, {"mad", "play"},
                {"kim", "mad"}, {"taeng", "play"}
        };

        Set<String> namesWithFlatMap = Arrays.stream(namesArray)
                .flatMap(innerArray -> Arrays.stream(innerArray))
                .filter(name -> name.length() > 3)
                .collect(Collectors.toSet());

        for (String s : namesWithFlatMap) {
            System.out.println(s);
        }


        List<Integer> first = Arrays.asList(1, 2, 3);
        List<Integer> second = Arrays.asList(3, 4);


        List<int[]> ints = first
                .stream()
                .flatMap(f -> second.stream().map(s -> new int[]{f, s}))
                .toList();

        for (int[] anInt : ints) {
            System.out.println("OUTER");

            for (int i : anInt) {
                System.out.print(i + " ");
            }
            System.out.println();
        }




        Stream<Integer> integerStream1 = first.stream().flatMap(i -> second.stream().map(s -> i + s));


    }
}
