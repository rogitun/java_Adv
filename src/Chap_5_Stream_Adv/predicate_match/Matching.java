package Chap_5_Stream_Adv.predicate_match;

import Chap_5_Stream_Adv.sample_data.Dish;
import Chap_5_Stream_Adv.sample_data.SampleDishes;

import java.util.List;

public class Matching {
    public static void main(String[] args) {

        List<Dish> noneVegeDishes = SampleDishes.getNoneVegeDishes();
        List<Dish> dishes = SampleDishes.getDishes();

        boolean dishAll = dishes.stream().allMatch(d -> d.isVegetarian());

        boolean allMatch = noneVegeDishes.stream().allMatch(vd -> vd.isVegetarian());

        System.out.println(dishAll);
        System.out.println(allMatch);
    }
}
