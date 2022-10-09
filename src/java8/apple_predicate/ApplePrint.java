package java8.apple_predicate;

import java8.Apple;
import java8.ApplePredicate;

public class ApplePrint implements ApplePredicate {
    @Override
    public String appleString(Apple a) {
        return a.color + " " + a.weight;
    }
}
