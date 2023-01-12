package Chap_9_Refactoring_Debugging.observer;

import java.util.ArrayList;
import java.util.List;

public class Feed implements Subject {

    private final List<Observer> observerList = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void notifyObserver(String tweet) {
        observerList.forEach(o -> o.notify(tweet));
    }
}
