package Chap_9_Refactoring_Debugging.strategy.string_match;

import Chap_9_Refactoring_Debugging.strategy.ValidationStrategy;

public class IsNumeric implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
