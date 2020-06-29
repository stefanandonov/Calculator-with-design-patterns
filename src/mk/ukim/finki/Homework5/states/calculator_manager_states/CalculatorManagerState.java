package mk.ukim.finki.Homework5.states.calculator_manager_states;

import mk.ukim.finki.Homework5.CalculatorManager;

public abstract class CalculatorManagerState {

    CalculatorManager calculatorManager;

    public CalculatorManagerState(CalculatorManager calculatorManager) {
        this.calculatorManager = calculatorManager;
    }

    public abstract void pressProg();

    public abstract void pressRcl();

    public abstract void acceptKey(String keyStroke);
}
