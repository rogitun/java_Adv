package Chap_9_Refactoring_Debugging.template;

public class Template {
    public static void main(String[] args) {
        new KHBanking().processCustomerWithLambda(1234, (Customer c) -> {
            System.out.println("Make our customer Happy");
        });
    }
}
