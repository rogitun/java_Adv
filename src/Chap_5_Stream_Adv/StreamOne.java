package Chap_5_Stream_Adv;

import Chap_5_Stream_Adv.sample_data.Dish;
import Chap_5_Stream_Adv.sample_data.SampleDishes;

import java.util.ArrayList;
import java.util.List;

public class StreamOne {
    public static void main(String[] args) {
        List<Dish> veget = new ArrayList<>();
        List<Dish> menu = SampleDishes.getDishes();

        for (Dish dish : menu) {
            if(dish.isVegetarian()){
                veget.add(dish);
            }
        }

        // -> Stream 변환

        menu.stream()
                .filter(Dish::isVegetarian)
                .map(veget::add);

        for (Dish dish : veget) {
            System.out.println(dish);
        }
    }
}
