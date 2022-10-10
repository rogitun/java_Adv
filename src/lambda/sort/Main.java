package lambda.sort;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class Main {

    public static class Obj {
        int weight;
        String color;

        public Obj(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public String getColor() {
            return color;
        }

        public String toString() {
            return "w : " + weight + " color : " + color;
        }
    }

    public static void main(String[] args) {

        List<Obj> list = new ArrayList<>();
        list.add(new Obj(3, "hansel"));
        list.add(new Obj(9, "anthony"));
        list.add(new Obj(3, "chris"));
        list.add(new Obj(4, "teodor"));


//        list.sort(new ObjComparator());
//        list.sort(new Comparator<Obj>() {
//            @Override
//            public int compare(Obj o1, Obj o2) {
//                return o1.weight - o2.weight;
//            }
//        });
//        list.sort((o1,o2) -> o1.weight - o2.weight);
        list.sort(
                comparing(Obj::getWeight)
                        .reversed()
                        .thenComparing(Obj::getColor)
        );

        for (Obj obj : list) {
            System.out.println(obj.toString());
        }


    }
}
