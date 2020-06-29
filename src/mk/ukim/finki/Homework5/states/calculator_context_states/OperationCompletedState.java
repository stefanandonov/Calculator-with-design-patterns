package mk.ukim.finki.Homework5.states.calculator_context_states;

import mk.ukim.finki.Homework5.CalculatorContext;

public class OperationCompletedState extends CalculatorState {

    private static final Character DOT = '.';

    public OperationCompletedState(CalculatorContext calculatorContext) {
        super(calculatorContext);
    }

    public OperationCompletedState() {
        super();
    }

    @Override
    public String displayContent() {
        return "In OperationCompletedState\n" + super.displayContent();
    }

    @Override
    public void pressNumericOrDecimalButton(char button) {
        calculatorContext.clearMembersExceptMemory();
        calculatorContext.clearDisplay();
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
        calculatorContext.clearDisplay();

        calculatorContext.setLeft(calculatorContext.getResult());
        calculatorContext.buildLeftOperandText();

        calculatorContext.setOperator(operator);

        calculatorContext.clearRight();

        calculatorContext.getDisplayContent().append(calculatorContext.getLeftAsText()).append(operator);

        CalculatorState pendingOperatorState = new PendingOperatorState(calculatorContext);
        calculatorContext.setCalculatorState(pendingOperatorState);
    }

    @Override
    public String pressEqualButton() {
        calculatorContext.clearDisplay();
        try {
            calculatorContext.calculateResult();
            calculatorContext.buildDisplay();
            calculatorContext.setLeft(calculatorContext.getResult());
            calculatorContext.buildLeftOperandText();
        } catch (Exception e) {
            calculatorContext.getDisplayContent().append(e.getMessage());
        }

        return calculatorContext.getDisplayContent().toString();
    }

    @Override
    public void pressMCButton() {
        calculatorContext.clearMemory();
        transitToMemoryAccessedState();
    }

    @Override
    public void pressMPlusButton() {
        calculatorContext.addToMemory(calculatorContext.getLeft());
        transitToMemoryAccessedState();
    }

    @Override
    public void pressMMinusButton() {
        calculatorContext.subtractFromMemory(calculatorContext.getLeft());
        transitToMemoryAccessedState();
    }

    @Override
    public void pressMRButton() {
        calculatorContext.clearRight();
        calculatorContext.setLeftText(calculatorContext.getMemory().toString());
        calculatorContext.buildLeftOperandValue();
        calculatorContext.clearDisplay();
        calculatorContext.getDisplayContent().append(calculatorContext.getLeftText());
        transitToMemoryAccessedState();
    }

    @Override
    public void pressMSButton() {
        calculatorContext.setMemory(calculatorContext.getResult());
        calculatorContext.clearRight();
        transitToMemoryAccessedState();
    }


    @Override
    public CalculatorState createEmptyState() {
        return new OperationCompletedState();
    }

    @Override
    public void pressChangeSignButton() {
        calculatorContext.clearDisplay();
        calculatorContext.setLeft(calculatorContext.getResult()*(-1));
        calculatorContext.buildLeftOperandText();

        calculatorContext.clearRight();
        calculatorContext.getDisplayContent().append(calculatorContext.getLeftAsText());

        CalculatorState pendingOperatorState = new PendingOperatorState(calculatorContext);
        calculatorContext.setCalculatorState(pendingOperatorState);
    }
}
