package mk.ukim.finki.Homework5.states.calculator_context_states;

import mk.ukim.finki.Homework5.CalculatorContext;

public class PendingOperatorState extends CalculatorState {

    private static final Character DOT = '.';

    public PendingOperatorState(CalculatorContext calculatorContext) {
        super(calculatorContext);
    }

    public PendingOperatorState() {
        super();
    }

    @Override
    public String displayContent() {
        return "In PendingOperatorState\n" + super.displayContent();
    }

    @Override
    public void pressNumericOrDecimalButton(char button) {
        StringBuilder sb = new StringBuilder();
        StringBuilder display = calculatorContext.getDisplayContent();

        sb.append(button == DOT ? "0" + button : button);
        display.append(button == DOT ? "0" + button : button);

        calculatorContext.setRightText(sb.toString());

        CalculatorState pendingRightOperandState = new PendingRightOperandState(calculatorContext);
        calculatorContext.setCalculatorState(pendingRightOperandState);
    }

    @Override
    public void pressOperatorButton(char operator) {
        calculatorContext.setOperator(operator);
        StringBuilder display = calculatorContext.getDisplayContent();
        if (!Character.isDigit(display.charAt(display.length()-1)))
            display.deleteCharAt(display.length() - 1);
        display.append(operator);
    }

    @Override
    public String pressEqualButton() {
        CalculatorState operationCompletedState = new OperationCompletedState(calculatorContext);
        StringBuilder display = calculatorContext.getDisplayContent();
        calculatorContext.buildLeftOperandValue();
        if (calculatorContext.isRightOperandEmpty()) {
            calculatorContext.setRight(calculatorContext.getLeft());
            calculatorContext.buildRightOperandText();
            try {
                calculatorContext.calculateResult();
                display.append(calculatorContext.getRightText());
                calculatorContext.appendResult();
            } catch (Exception e) {
                display.append(e.getMessage());
            }

        } else {
            calculatorContext.buildRightOperandValue();
            try {
                calculatorContext.calculateResult();
                calculatorContext.appendResult();
                calculatorContext.setLeft(calculatorContext.getResult());
                calculatorContext.setRight(calculatorContext.getResult());
                calculatorContext.buildOperandTexts();
            } catch (Exception e) {
                display.append(e.getMessage());
            }

        }

        calculatorContext.setCalculatorState(operationCompletedState);
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
        calculatorContext.setRightText(calculatorContext.getMemory().toString());
        calculatorContext.buildRightOperandValue();
        calculatorContext.getDisplayContent().append(calculatorContext.getMemory());
        transitToMemoryAccessedState();
    }

    @Override
    public void pressMSButton() {
        calculatorContext.setMemory(calculatorContext.getLeft());
        transitToMemoryAccessedState();

    }

    @Override
    public CalculatorState createEmptyState() {
        return new PendingOperatorState();
    }

    @Override
    public void pressChangeSignButton() {
        if (calculatorContext.isRightOperandEmpty()) {
            calculatorContext.setRightText("-");
            calculatorContext.getDisplayContent().append("-");
        }
        else {
            if (calculatorContext.getRightText().charAt(0)=='-') {
                calculatorContext.clearRight();
                calculatorContext.getDisplayContent().deleteCharAt(calculatorContext.getDisplayContent().length()-1);
            }
        }
        calculatorContext.setCalculatorState(new PendingRightOperandState(calculatorContext));
    }

}
