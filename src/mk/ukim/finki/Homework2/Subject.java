//package mk.ukim.finki.Homework2;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.TreeMap;
//
//public abstract class Subject {
//
//
//    Map<Integer, Observer> observerMap = new TreeMap<>();
//    private static int count = 0;
//
//    public Subject() {
//
//        observerMap = new TreeMap<>();
//    }
//
//    public void attach(Observer observer) {
//
//        if (!observer.isAttached())
//            observerMap.put(count++, observer);
//    }
//
//
//    public void detach(int number) {
//
//        observerMap.remove(number);
//    }
//
//    public abstract void notifyObservers();
//}
