package a_java8.apple_predicate;

import a_java8.Apple;
import a_java8.ApplePredicate;

public class ApplePrint implements ApplePredicate {
    @Override
    public String appleString(Apple a) {
        return a.color + " " + a.weight;
    }
}
