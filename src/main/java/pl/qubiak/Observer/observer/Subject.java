package pl.qubiak.Observer.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    public List<Observer> observerList;

    public Subject() {

        observerList = new ArrayList<>();
    }

    public void addObserverList(Observer observerList) {
        this.observerList.add(observerList);
    }

    public void startWork() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //prejście 100 razy po pętli for, ale nie wiemy kiedy wątek się zakończy
                for (int i = 0; i < 100; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (Observer observer : observerList) {
                    observer.update();
                }
                //weryfikujemy czy wątek zakończył pracę
            }
        });
        thread.start();
    }
}
