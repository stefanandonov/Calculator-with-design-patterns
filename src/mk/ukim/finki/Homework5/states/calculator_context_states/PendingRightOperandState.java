package mk.ukim.finki.Homework5.states.calculator_context_states;

import mk.ukim.finki.Homework5.CalculatorContext;

public class PendingRightOperandState extends CalculatorState {
    public PendingRightOperandState(CalculatorContext calculatorContext) {
        super(calculatorContext);
    }

    public PendingRightOperandState() {
        super();
    }


    @Override
    public String displayContent() {
        return "In PendingRightOperandState\n" + super.displayContent();
    }

    @Override
    public void pressNumericOrDecimalButton(char button) {
        if (calculatorContext.isRightOperandEmpty())
            calculatorContext.setRightText("");

        if (calculatorContext.getRightText().contains(".") && button == '.')
            return;

        calculatorContext.setRightText(calculatorContext.getRightText() + button);
        calculatorContext.getDisplayContent().append(button);
    }

    @Override
    public void pressOperatorButton(char operator) {
        //todo fix with using the calculate result from the calculator context (the strategy is already in the context)
        CalculatorState pendingOperatorState = new PendingOperatorState(calculatorContext);

        calculatorContext.buildOperandValues();

        try {
            calculatorContext.calculateResult();
            calculatorContext.setLeft(calculatorContext.getResult());
            calculatorContext.buildLeftOperandText();

            calculatorContext.clearRight();

            calculatorContext.setOperator(operator);
            calculatorContext.getDisplayContent().append(operator);
        } catch (Exception e) {
            calculatorContext.getDisplayContent().append(e.getMessage());
        }

        calculatorContext.setCalculatorState(pendingOperatorState);


    }

    @Override
    public String pressEqualButton() {
        CalculatorState operationCompletedState = new OperationCompletedState(calculatorContext);

        calculatorContext.buildOperandValues();
        try {
            calculatorContext.calculateResult();
            calculatorContext.setLeft(calculatorContext.getResult());
            calculatorContext.buildLeftOperandText();
            calculatorContext.appendResult();
        } catch (Exception e) {
            calculatorContext.getDisplayContent().append(e.getMessage());
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
        calculatorContext.buildRightOperandValue();
        calculatorContext.addToMemory(calculatorContext.getRight());
        transitToMemoryAccessedState();
    }

    @Override
    public void pressMMinusButton() {
        calculatorContext.buildRightOperandValue();
        calculatorContext.subtractFromMemory(calculatorContext.getRight());
        transitToMemoryAccessedState();
    }

    @Override
    public void pressMRButton() {
        calculatorContext.setRightText(calculatorContext.getMemory().toString());
        transitToMemoryAccessedState();
    }

    @Override
    public void pressMSButton() {
        calculatorContext.buildRightOperandValue();
        //calculatorContext.clearLeft();
        calculatorContext.setMemory(calculatorContext.getRight());
        transitToMemoryAccessedState();
    }

    @Override
    public CalculatorState createEmptyState() {
        return new PendingRightOperandState();
    }

    @Override
    public void pressChangeSignButton() {
        String rightText = calculatorContext.getRightText();
        int position = calculatorContext.getDisplayContent().lastIndexOf(rightText);
        int size = rightText.length();
        rightText = (rightText.startsWith("-")) ? rightText.substring(1) : ("-"+rightText);
        calculatorContext.setRightText(rightText);
        calculatorContext.getDisplayContent().replace(position, position+size, rightText);
    }
}
