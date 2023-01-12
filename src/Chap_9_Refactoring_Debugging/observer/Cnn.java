package Chap_9_Refactoring_Debugging.observer;

public class Cnn implements Observer {
    @Override
    public void notify(String tweet) {
        if (!tweet.isEmpty() && tweet.contains("money")) {
            System.out.println("Breaking News about Money ! " + tweet);
        }
    }
}
