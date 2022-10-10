package a_java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        MyUtils myUtils = new MyUtils();

        List<Apple> list = new ArrayList<>();

        list.add(new Apple(4, "GREEN")); // O
        list.add(new Apple(3, "RED")); // X
        list.add(new Apple(6, "PINK")); // O
        list.add(new Apple(15, "GREEN")); // O
        list.add(new Apple(-1, "BLUE")); // X

//        myUtils.filter(list, (TempData t) -> t.color.equals("GREEN"));

//        list.stream()
//                .filter(t -> t.color.equals("GREEN") && t.number > 3)
//                .forEach(TempData::toPrint);


        MyUtils.prettyApple(list, (Apple a)-> a.color + " / " + a.weight);
        list.sort(Comparator.comparingInt(a -> a.weight));
    }
}
