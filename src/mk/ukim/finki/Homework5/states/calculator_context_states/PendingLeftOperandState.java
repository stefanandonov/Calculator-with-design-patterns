package mk.ukim.finki.Homework5.states.calculator_context_states;

import mk.ukim.finki.Homework5.CalculatorContext;

public class PendingLeftOperandState extends CalculatorState {

    private static final Character PLUS_OPERATOR = '+';
    private static final String ZERO_TEXT = "0";
    private static final Character DOT = '.';

    public PendingLeftOperandState(CalculatorContext calculatorContext) {
        super(calculatorContext);
    }

    public PendingLeftOperandState() {
        super();
    }

    @Override
    public String displayContent() {
        return "In PendingLeftOperandState\n" + super.displayContent();
    }

    @Override
    public void pressNumericOrDecimalButton(char button) {

        if (calculatorContext.leftOperandTextContainsDecimal() && button == DOT)
            return;

        calculatorContext.appendToLeftOperandText(button);
        calculatorContext.getDisplayContent().append(button);
    }

    @Override
    public void pressOperatorButton(char operator) {
        CalculatorState pendingOperatorState = new PendingOperatorState(calculatorContext);
        calculatorContext.buildLeftOperandValue();
        calculatorContext.setOperator(operator);
        calculatorContext.getDisplayContent().append(operator);
        calculatorContext.setCalculatorState(pendingOperatorState);
    }

    @Override
    public String pressEqualButton() {
        CalculatorState operationCompletedState = new OperationCompletedState(calculatorContext);
        calculatorContext.setOperator(PLUS_OPERATOR);
        calculatorContext.setRightText(ZERO_TEXT);
        calculatorContext.buildOperandValues();
        try {
            calculatorContext.calculateResult();
            calculatorContext.appendResult();
            calculatorContext.setCalculatorState(operationCompletedState);
        } catch (Exception e) {
            calculatorContext.getDisplayContent().append(e.getMessage());
        }

        return calculatorContext.getDisplayContent().toString();
    }

    @Override
    public void pressMCButton() {
        calculatorContext.buildLeftOperandValue();
        calculatorContext.clearMemory();
        transitToMemoryAccessedState();
    }

    @Override
    public void pressMPlusButton() {
        calculatorContext.buildLeftOperandValue();
        calculatorContext.addToMemory(calculatorContext.getLeft());
       transitToMemoryAccessedState();
    }

    @Override
    public void pressMMinusButton() {
        calculatorContext.buildLeftOperandValue();
        calculatorContext.subtractFromMemory(calculatorContext.getLeft());
        transitToMemoryAccessedState();
    }

    @Override
    public void pressMRButton() {
        calculatorContext.setLeftText(calculatorContext.getMemory().toString());
        calculatorContext.buildLeftOperandValue();
        calculatorContext.clearDisplay();
        calculatorContext.getDisplayContent().append(calculatorContext.getLeftText());
        transitToMemoryAccessedState();
    }

    @Override
    public void pressMSButton() {
        calculatorContext.buildLeftOperandValue();
        calculatorContext.setMemory(calculatorContext.getLeft());
        transitToMemoryAccessedState();
    }


    @Override
    public CalculatorState createEmptyState() {
        return new PendingLeftOperandState();
    }

    @Override
    public void pressChangeSignButton() {
        String leftText = calculatorContext.getLeftText();
        int position = calculatorContext.getDisplayContent().lastIndexOf(leftText);
        int size = leftText.length();
        leftText = (leftText.startsWith("-")) ? leftText.substring(1) : ("-"+leftText);
        calculatorContext.setLeftText(leftText);
        calculatorContext.getDisplayContent().replace(position, position+size, leftText);



    }
}
