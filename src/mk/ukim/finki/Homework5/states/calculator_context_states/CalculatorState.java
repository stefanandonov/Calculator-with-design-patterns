package mk.ukim.finki.Homework5.states.calculator_context_states;

import mk.ukim.finki.Homework5.CalculatorContext;

public abstract class CalculatorState {

    protected CalculatorContext calculatorContext;

    public CalculatorState() {
        calculatorContext = null;
    }

    public CalculatorState(CalculatorContext calculatorContext) {
        this.calculatorContext = calculatorContext;
    }

    public String displayContent() {
        return calculatorContext.toString();
    }

    public abstract void pressNumericOrDecimalButton(char button);

    public abstract void pressOperatorButton(char operator);

    public abstract String pressEqualButton();

    public abstract void pressMCButton();

    public abstract void pressMPlusButton();

    public abstract void pressMMinusButton();

    public abstract void pressMRButton();

    public abstract void pressMSButton();

    public void transitToMemoryAccessedState() {
        CalculatorState state = new MemoryAccessedState(this.calculatorContext);
        calculatorContext.setCalculatorState(state);
    }

    public void setCalculatorContext(CalculatorContext calculatorContext) {
        this.calculatorContext = calculatorContext;
    }
    public abstract CalculatorState createEmptyState();

    public abstract void pressChangeSignButton();
}
