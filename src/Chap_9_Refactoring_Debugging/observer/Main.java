package Chap_9_Refactoring_Debugging.observer;

public class Main {
    public static void main(String[] args) {
        Feed feed = new Feed();
        //feed.registerObserver(new Cnn()); //구현된 클래스 사용

        feed.registerObserver((String tweet)->{
            if(!tweet.isEmpty() && tweet.contains("money")){
                System.out.println("Breaking News about money" + tweet);
            }
        });

        feed.notifyObserver("I don't have money");
    }
}
