package Chap_9_Refactoring_Debugging.strategy;

import Chap_9_Refactoring_Debugging.strategy.string_match.IsAllLowerCase;
import Chap_9_Refactoring_Debugging.strategy.string_match.IsNumeric;
import Chap_9_Refactoring_Debugging.strategy.string_match.Validator;

public class Strategy {
    public static void main(String[] args) {
        Validator validatorNumeric = new Validator(new IsNumeric());
        Validator validatorLowerCase = new Validator(new IsAllLowerCase());

        String allLower = "abcd";
        String notLower = "AdVD";
        String numeric = "123321";
        String notNumeric = "ads123";

        System.out.println("is numeric ? " + validatorNumeric.validate(numeric)); // true
        System.out.println("is numeric ? " + validatorNumeric.validate(notNumeric)); // false
        System.out.println("is allLower ? " + validatorLowerCase.validate(allLower)); // yes
        System.out.println("is allLower ? " + validatorLowerCase.validate(notLower)); // false


        Validator lowerCaseValidator = new Validator((String s) -> s.matches("[a-z]+"));
        Validator numericValidator = new Validator((String s) -> s.matches("\\d+"));

    }
}
