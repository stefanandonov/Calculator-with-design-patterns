package mk.ukim.finki.Homework5.states.calculator_context_states;

import mk.ukim.finki.Homework5.CalculatorContext;

public class MemoryAccessedState extends CalculatorState {

    private static final Character DOT = '.';

    public MemoryAccessedState() {
        super();
    }

    public MemoryAccessedState(CalculatorContext calculatorContext) {
        super(calculatorContext);
    }

    @Override
    public String displayContent() {
        return "In Memory accessed state " + super.displayContent();
    }

    @Override
    public void pressNumericOrDecimalButton(char button) {
        StringBuilder sb = new StringBuilder();
        sb.append(button == DOT ? "0" + button : button);
        calculatorContext.clearDisplay();
        if (calculatorContext.isRightOperandEmpty()) {
            calculatorContext.clearLeft();
            calculatorContext.appendToLeftText(sb.toString());
            calculatorContext.getDisplayContent().append(button == DOT ? "0" + button : button);
        }
        else {
            calculatorContext.clearRight();
            calculatorContext.setRightText(sb.toString());
            calculatorContext.getDisplayContent().append(calculatorContext.getLeftText())
                    .append(calculatorContext.getOperator())
                    .append(calculatorContext.getRightText());
        }
        CalculatorState pendingLeftOperandState = new PendingLeftOperandState(this.calculatorContext);
        calculatorContext.setCalculatorState(pendingLeftOperandState);

    }

    @Override
    public void pressOperatorButton(char operator) {
        calculatorContext.clearDisplay();

        if (calculatorContext.isLeftOperandNotEmpty() && !calculatorContext.isRightOperandEmpty()) {
            try {
                calculatorContext.buildOperandValues();
                calculatorContext.calculateResult();
                calculatorContext.setLeftText(calculatorContext.getResult().toString());

            } catch (Exception e) {
                calculatorContext.getDisplayContent().append(e.getMessage());
            }
        }
        calculatorContext.setOperator(operator);

        calculatorContext.getDisplayContent()
                .append(calculatorContext.getLeftText().isEmpty() ? "" : calculatorContext.getLeftText())
                .append(operator);

        CalculatorState pendingOperatorState = new PendingOperatorState(this.calculatorContext);
        calculatorContext.setCalculatorState(pendingOperatorState);
    }

    @Override
    public String pressEqualButton() {
        calculatorContext.clearDisplay();
        try {
            calculatorContext.buildOperandValues();
            calculatorContext.calculateResult();
            calculatorContext.buildDisplay();

        } catch (Exception e) {
            calculatorContext.getDisplayContent().append(e.getMessage());
        }
        return calculatorContext.getDisplayContent().toString();
    }

    @Override
    public void pressMCButton() {
        calculatorContext.clearMemory();
    }

    @Override
    public void pressMPlusButton() {
        if (calculatorContext.getRight() != null) {
            calculatorContext.addToMemory(calculatorContext.getRight());
        } else if (calculatorContext.getLeft() != null) {
            calculatorContext.addToMemory(calculatorContext.getLeft());
        }
    }

    @Override
    public void pressMMinusButton() {
        if (calculatorContext.getRight() != null) {
            calculatorContext.subtractFromMemory(calculatorContext.getRight());
        } else if (calculatorContext.getLeft() != null) {
            calculatorContext.subtractFromMemory(calculatorContext.getLeft());
        }
    }

    @Override
    public void pressMRButton() {
        calculatorContext.clearLeft();
        calculatorContext.clearRight();
        calculatorContext.appendToLeftText(calculatorContext.getMemory().toString());
        calculatorContext.clearDisplay();
        calculatorContext.getDisplayContent().append(calculatorContext.getLeftText());
        calculatorContext.buildLeftOperandValue();
    }

    @Override
    public void pressMSButton() {
        //do nothing
    }


    @Override
    public CalculatorState createEmptyState() {
        return new MemoryAccessedState();
    }

    @Override
    public void pressChangeSignButton() {
        //TODO simplify this
        if (calculatorContext.isRightOperandEmpty()) {
            if (calculatorContext.isLeftOperandNotEmpty()) {
                String leftText = calculatorContext.getLeftText();
                int position = calculatorContext.getDisplayContent().lastIndexOf(leftText);
                int size = leftText.length();
                leftText = (leftText.startsWith("-")) ? leftText.substring(1) : ("-" + leftText);
                calculatorContext.setLeftText(leftText);
                calculatorContext.getDisplayContent().replace(position, position + size, leftText);
                calculatorContext.setCalculatorState(new PendingOperatorState(calculatorContext));
            }
        }
        else {
            String rightText = calculatorContext.getRightText();
            int position = calculatorContext.getDisplayContent().lastIndexOf(rightText);
            int size = rightText.length();
            rightText = (rightText.startsWith("-")) ? rightText.substring(1) : ("-"+rightText);
            calculatorContext.setRightText(rightText);
            calculatorContext.getDisplayContent().replace(position, position+size, rightText);
            calculatorContext.setCalculatorState(new PendingOperatorState(calculatorContext));
        }
    }
}
