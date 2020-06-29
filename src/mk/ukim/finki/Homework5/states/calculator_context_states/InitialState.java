package mk.ukim.finki.Homework5.states.calculator_context_states;

import mk.ukim.finki.Homework5.CalculatorContext;

public class InitialState extends CalculatorState {

    private static Double ZERO = 0.0;
    private static String ZERO_TEXT = "0";
    private static Character DOT = '.';

    public InitialState() {
        super();
    }

    public InitialState(CalculatorContext calculatorContext) {
        super(calculatorContext);
    }

    @Override
    public String displayContent() {
        return "In InitialState\n" + super.displayContent();
    }

    @Override
    public void pressNumericOrDecimalButton(char button) {
        StringBuilder sb = new StringBuilder();
        StringBuilder display = calculatorContext.getDisplayContent();

        sb.append(button == DOT ? "0" + button : button);
        display.append(button == DOT ? "0" + button : button);

        calculatorContext.appendToLeftText(sb.toString());

        CalculatorState pendingLeftOperandState = new PendingLeftOperandState(calculatorContext);
        calculatorContext.setCalculatorState(pendingLeftOperandState);
    }

    @Override
    public void pressOperatorButton(char operator) {
        //do nothing, stay in the same state
    }

    @Override
    public String pressEqualButton() {
        return null;
    }

    @Override
    public void pressMCButton() {
        calculatorContext.setMemory(ZERO);
        transitToMemoryAccessedState();
    }

    @Override
    public void pressMPlusButton() {
        calculatorContext.addToMemory(ZERO);
        transitToMemoryAccessedState();
    }

    @Override
    public void pressMMinusButton() {
        calculatorContext.subtractFromMemory(ZERO);
        transitToMemoryAccessedState();
    }

    @Override
    public void pressMRButton() {
        calculatorContext.appendToLeftText(ZERO_TEXT);
        calculatorContext.getDisplayContent().append(ZERO_TEXT);
        transitToMemoryAccessedState();
    }

    @Override
    public void pressMSButton() {
        calculatorContext.setMemory(ZERO);
        transitToMemoryAccessedState();
    }


    @Override
    public CalculatorState createEmptyState() {
        return new InitialState();
    }

    @Override
    public void pressChangeSignButton() {

    }
}
