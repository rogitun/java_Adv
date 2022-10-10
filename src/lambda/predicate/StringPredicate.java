package lambda.predicate;

@FunctionalInterface
public interface StringPredicate<T> {

    boolean test(T t);
}
