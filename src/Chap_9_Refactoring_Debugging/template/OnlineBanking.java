package Chap_9_Refactoring_Debugging.template;

import javax.xml.crypto.Data;
import java.util.function.Consumer;

public abstract class OnlineBanking {
    public void processCustomer(int id) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy(c);
    }

    public void processCustomerWithLambda(int id, Consumer<Customer> makeCustomerHappy) {
        Customer customerWithId = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(customerWithId);
    }

    abstract void makeCustomerHappy(Customer c);
}
