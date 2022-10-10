package lambda.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateMain {
    public static void main(String[] args) {
        String abc = "abcHansel";

        List<String> list = new ArrayList<>();
        list.add("hansel");
        list.add("hansel2");
        list.add("hansel3");

        predicate(list, (String s) -> s.startsWith("h"));


    }

    public static void predicate(List<String> list, Predicate<String> p) {
        List<String> collect = list.stream()
                .filter(s -> p.test(s))
                .collect(Collectors.toList());

        for (String s : collect) {
            System.out.println(s);
        }
    }
}
