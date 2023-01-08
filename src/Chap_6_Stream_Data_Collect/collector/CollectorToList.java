package Chap_6_Stream_Data_Collect.collector;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CollectorToList {
    public static void main(String[] args) {

    }

    public static<T> Supplier<List<T>> supplier(){
        return () -> new ArrayList<T>();
    }

    public static<T> BiConsumer<List<T>,T> accumulator(){
        return List::add;
    }

    public static<T> Function<List<T>,List<T>> finisher(){
        return Function.identity(); //항상 input을 반환하는 메서드.
    }

    public static<T>BinaryOperator<List<T>> combiner(){
        return (list1,list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }
}
