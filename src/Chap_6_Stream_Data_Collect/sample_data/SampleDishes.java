package Chap_6_Stream_Data_Collect.sample_data;

import java.util.ArrayList;
import java.util.List;

public class SampleDishes {

    private static List<Dish> dishes = new ArrayList<>();
    private static List<Dish> noneVegeDishes = new ArrayList<>();

    private static List<Dish> zeroCaloryDishes = new ArrayList<>();



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

    public static List<Dish> getZeroCaloryDishes(){
        if(zeroCaloryDishes.size()==0){
            zeroCaloryDishes.add(new Dish("asds",true,null, Dish.Type.MEAT));
            zeroCaloryDishes.add(new Dish("asds22",true,null, Dish.Type.FISH));
            zeroCaloryDishes.add(new Dish("asds33",false,null, Dish.Type.OTHER));
            zeroCaloryDishes.add(new Dish("asds44",true,null, Dish.Type.MEAT));
            zeroCaloryDishes.add(new Dish("asds55",false,null, Dish.Type.MEAT));
        }
        return zeroCaloryDishes;
    }



}
