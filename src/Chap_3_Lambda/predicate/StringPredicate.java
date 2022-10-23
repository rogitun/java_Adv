package Chap_3_Lambda.predicate;

@FunctionalInterface
public interface StringPredicate<T> {

    boolean test(T t);
}
