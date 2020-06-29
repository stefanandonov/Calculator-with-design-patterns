//package mk.ukim.finki.Homework2;
//
//public class Observer implements IObserver {
//
//    private double calculatedValue;
//    private OperationStrategy strategy;
//    private double opValue;
//    private boolean attached = false;
//
//    Observer (Register register, char operation, double opValue) {
//        strategy = StrategiesFactory.createStrategy(operation);
//        this.opValue = opValue;
//        calculatedValue = strategy.execute(register.getValue(), opValue);
//        register.attach(this);
//        this.attached = true;
//    }
//
//    public boolean isAttached() {
//        return attached;
//    }
//
//    @Override
//    public void update(double value) {
//        this.calculatedValue = strategy.execute(value, this.opValue);
//    }
//
//    public double getValue() {
//        return calculatedValue;
//    }
//}
