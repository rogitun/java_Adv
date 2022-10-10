package a_java00;

import java.util.function.Consumer;

public class ConsumerInterface {
    public static void main(String[] args) {
        Consumer<String> print = s -> System.out.println(s);
        print.accept("hello");
    }
}
