package Chap_9_Refactoring_Debugging.c9_1;

import Chap_6_Stream_Data_Collect.sample_data.Dish;
import Chap_6_Stream_Data_Collect.sample_data.SampleDishes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Refactoring {
    public static void main(String[] args) {
        // 1. 익명클래스를 람다 표현식으로 리팩토링

        doSth(new Task() {
            @Override
            public void execute() {
                System.out.println("Task Executed");
            }
        });

        doSth((Runnable) () -> {
            System.out.println("?? Executed");
        });

        List<Dish> dishes = SampleDishes.getDishes();
        Map<String, List<Dish>> collect = dishes.stream()
                .collect(Collectors.groupingBy(dish -> {
                    if (dish.getCalory() > 500) return "heavy";
                    else return "light";
                }));

        Map<String, List<Dish>> collect1 = dishes.stream()
                .collect(Collectors.groupingBy(Dish::groupByCalory));


        //명령형 처리를 스트림으로 리팩토링하기
        List<String> dishNames = new ArrayList<>();
        for (Dish dish : dishes) {
            if (dish.getCalory() > 300) {
                dishNames.add(dish.getName());
            }
        }
        //1. dishNames에 add를 할 필요 없이 300이상 filter처리하고 collections으로 담는다.

        dishes.stream()
                .filter(d -> d.getCalory()>300)
                .map(Dish::getName)
                .collect(Collectors.toList());

    }

    interface Task {
        public void execute();
    }

    public static void doSth(Runnable r) {
        r.run();
    }

    public static void doSth(Task t) {
        t.execute();
    }

}
