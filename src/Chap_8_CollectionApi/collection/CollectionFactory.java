package Chap_8_CollectionApi.collection;

import Chap_6_Stream_Data_Collect.sample_data.Dish;
import Chap_6_Stream_Data_Collect.sample_data.SampleDishes;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionFactory {
    public static void main(String[] args) {
        //적은 요소를 포함하는 리스트 생성.

        List<String> strings = Arrays.asList("ab", "bc", "cd"); //고정 크기의 리스트가 생성된다.
//        strings.add("abc");

//        Set<String> abcd = Set.of("Abcd", "DSD", "DSD");


        Map<String, String> k1 = Map.of("k1", "v3", "k2", "v2");

//        k1.entrySet().forEach(e -> {
//            System.out.println(e.getKey() + " " + e.getValue());
//        });
//
//        k1.forEach((k,v)->{
//            System.out.println("key = " + k + " val = " + v);
//        });

        k1.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(System.out::println); //병렬 스트림인 경우에도 순서가 보장됨.

        List<Dish> dishes = SampleDishes.getDishes();
//
//
//        dishes.forEach(d -> {
//            System.out.println(d.getName() + " " + d.getCalory());
//        });
//        dishes.removeIf(d -> d.getCalory() > 300);
//        System.out.println("#REMOVED");
//        dishes.forEach(d -> {
//            System.out.println(d.getName() + " " + d.getCalory());
//        });
    }
}
