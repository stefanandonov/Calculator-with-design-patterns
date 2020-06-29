package mk.ukim.finki.Homework2;

public class StrategiesFactory {
    private static final OperationStrategy ADDITION = (Double::sum);
    private static final OperationStrategy SUBTRACTION = (a, b) -> a-b;
    private static final OperationStrategy MULTIPLICATION = (a, b) -> a*b;
    private static final OperationStrategy DIVISION = ((a, b) -> {
        if (b==0)
            throw new Exception("Division with ZERO is not possible!");
        return a/b;
    });

    public static OperationStrategy createStrategy(char op) {
        switch (op) {
            case '+':
                return ADDITION;
            case '-':
                return SUBTRACTION;
            case '*':
                return MULTIPLICATION;
            case '/':
                return DIVISION;
            default:
                return ADDITION;
        }
    }
}
