package Chap_5_Stream_Adv.sample_data;

import java.util.ArrayList;
import java.util.List;

public class SampleDishes {

    private static List<Dish> dishes = new ArrayList<>();
    private static List<Dish> noneVegeDishes = new ArrayList<>();

    public static List<Dish> getDishes(){
        if(dishes.size() == 0){
            dishes.add(new Dish("season",true,120, Dish.Type.OTHER));
            dishes.add(new Dish("salmon",false,190, Dish.Type.FISH));
            dishes.add(new Dish("pizza",false,220, Dish.Type.OTHER));
            dishes.add(new Dish("Pork",false,230, Dish.Type.MEAT));
            dishes.add(new Dish("prawns",false,300, Dish.Type.FISH));
            dishes.add(new Dish("rice",false,350, Dish.Type.OTHER));
            dishes.add(new Dish("chicken",false,400, Dish.Type.MEAT));
            dishes.add(new Dish("french",true,530, Dish.Type.OTHER));
            dishes.add(new Dish("beef",false,700, Dish.Type.MEAT));
        }
        return dishes;
    }

    public static List<Dish> getNoneVegeDishes(){
        if(noneVegeDishes.size() == 0){
            noneVegeDishes.add(new Dish("season",true,120, Dish.Type.OTHER));
            noneVegeDishes.add(new Dish("salmon",true,190, Dish.Type.FISH));
            noneVegeDishes.add(new Dish("pizza",true,220, Dish.Type.OTHER));
            noneVegeDishes.add(new Dish("Pork",true,230, Dish.Type.MEAT));
        }
        return noneVegeDishes;
    }

}
