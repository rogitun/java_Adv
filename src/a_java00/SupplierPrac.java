package a_java00;

import java.util.concurrent.TimeUnit;

public class SupplierPrac {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        printIfValid(0, getExpensiveValue());
        printIfValid(-2, getExpensiveValue());
        printIfValid(-1,getExpensiveValue());

        System.out.println("it took " + (System.currentTimeMillis() - start) / 1000);
    }

       private static String getExpensiveValue(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hansel";
    }

    private static void printIfValid(int isTrue, String value) {
//        private static void printIfValid(int isTrue, Supplier<String> valueSupplier) {
            if (isTrue >= 0) {
            System.out.println("the value is " + value + ".");
        } else {
            System.out.println("Invalid");
        }
    }
}
