//package mk.ukim.finki.Homework2;
//
//import java.util.stream.Collectors;
//
//public class Register extends Subject {
//
//    double value;
//
//    public Register(double value) {
//        super();
//        this.value = value;
//    }
//
//    public double getValue() {
//        return value;
//    }
//
//    public void setValue(double value) {
//        //main business logic of the Publisher (Subject)
//        this.value = value;
//        notifyObservers();
//    }
//
//    @Override
//    public void notifyObservers() {
//        this.observerMap.values().forEach(observer -> observer.update(this.value));
//    }
//
//    @Override
//    public String toString() {
//        if (observerMap.size()==0)
//            return "NONE";
//
//        return observerMap.entrySet()
//                .stream()
//                .map(entry -> String.format("Observer #%d is %.2f",
//                        entry.getKey(),
//                        entry.getValue().getValue()))
//                .collect(Collectors.joining("\n"));
//    }
//}
