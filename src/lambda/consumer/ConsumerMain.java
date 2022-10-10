package lambda.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerMain {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hansel");
        list.add("hansel2");
        list.add("hansel3");


        consumer(list,(String s)-> System.out.println(s));

    }

    public static <T> void consumer(List<T> list, Consumer<T> p){
        list.forEach(l -> p.accept(l));
    }
}
