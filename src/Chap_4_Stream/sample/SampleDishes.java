package Chap_4_Stream.sample;

import java.util.ArrayList;
import java.util.List;

public class SampleDishes {

    private static List<Dish> dishes = new ArrayList<>();

    public static List<Dish> getDishes(){
        if(dishes.size() == 0){
            dishes.add(new Dish("Pork",false,230, Dish.Type.MEAT));
            dishes.add(new Dish("beef",false,700, Dish.Type.MEAT));
            dishes.add(new Dish("chicken",false,400, Dish.Type.MEAT));
            dishes.add(new Dish("french",true,530, Dish.Type.OTHER));
            dishes.add(new Dish("rice",false,350, Dish.Type.OTHER));
            dishes.add(new Dish("season",true,120, Dish.Type.OTHER));
            dishes.add(new Dish("pizza",false,220, Dish.Type.OTHER));
            dishes.add(new Dish("prawns",false,300, Dish.Type.FISH));
            dishes.add(new Dish("salmon",false,190, Dish.Type.FISH));
        }
        return dishes;
    }

}
