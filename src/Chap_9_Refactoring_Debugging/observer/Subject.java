package Chap_9_Refactoring_Debugging.observer;

public interface Subject {
    void registerObserver(Observer o);

    void notifyObserver(String tweet);
}
