package Chap_9_Refactoring_Debugging.strategy.string_match;

import Chap_9_Refactoring_Debugging.strategy.ValidationStrategy;

public class Validator {
    private final ValidationStrategy validationStrategy;

    public Validator(ValidationStrategy validationStrategy) {
        this.validationStrategy = validationStrategy;
    }

    public boolean validate(String s) {
        return validationStrategy.execute(s);
    }
}
