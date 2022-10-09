package java8;

import java.util.List;

public class MyUtils {

    public static final int LIMIT = 5;

//    public static boolean isGreen(TempData t) {
//        return t.color.equals("GREEN");
//    }
//
//    public static boolean isOverLimit(TempData t) {
//        return t.number > LIMIT;
//    }
//
//    public static boolean isUnderLimit(TempData t) {
//        return t.number < LIMIT;
//    }

    public interface Predicate<T> {
        boolean test(T t);
    }

//    public void filter(List<TempData> list, Predicate<TempData> p) {
//        for (TempData tempData : list) {
//            if (p.test(tempData)) {
//                System.out.println(tempData.color + " " + tempData.number);
//            }
//        }
//    }

    public static void prettyApple(List<Apple> apples, ApplePredicate<Apple> p) {
        for (Apple apple : apples) {
            String output = p.appleString(apple);
            System.out.println(output);
        }
    }
}
