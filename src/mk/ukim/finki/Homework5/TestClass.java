package mk.ukim.finki.Homework5;

import java.util.Scanner;

public class TestClass {

    static CalculatorManager calculatorManager = new CalculatorManager();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            calculatorManager.acceptKey(input);
            System.out.println(calculatorManager.context.display());
        }
    }
}
