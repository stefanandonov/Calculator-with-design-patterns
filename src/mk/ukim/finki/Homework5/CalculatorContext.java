package mk.ukim.finki.Homework5;

import mk.ukim.finki.Homework5.strategy.OperationStrategy;
import mk.ukim.finki.Homework5.strategy.StrategiesFactory;
import mk.ukim.finki.Homework5.states.calculator_context_states.CalculatorState;
import mk.ukim.finki.Homework5.states.calculator_context_states.InitialState;
import mk.ukim.finki.Homework5.states.calculator_context_states.PendingLeftOperandState;


public class CalculatorContext {

    CalculatorState calculatorState;
    StringBuilder leftText;
    Double left;
    Character operator;
    StringBuilder rightText;
    Double right;
    Double result;
    Double memory;
    StringBuilder displayContent;


    public CalculatorContext() {
        calculatorState = new InitialState(this);
        leftText = new StringBuilder();
        rightText = new StringBuilder();
        memory = 0.0;
        displayContent = new StringBuilder();
    }

    public CalculatorContext(CalculatorState calculatorState) {
        this.calculatorState = calculatorState;
        leftText = new StringBuilder();
        rightText = new StringBuilder();
        memory = 0.0;
        displayContent = new StringBuilder();
    }

    public void setCalculatorState(CalculatorState calculatorState) {
        this.calculatorState = calculatorState;
    }

    public String display() {
        return calculatorState.displayContent();
    }

    public void pressNumericOrDecimalButton(char button) {
        calculatorState.pressNumericOrDecimalButton(button);
    }

    public void pressOperatorButton(char operator) {
        calculatorState.pressOperatorButton(operator);
    }

    public String pressEqualButton() {
        return calculatorState.pressEqualButton();
    }

    public void clearMembers() {
        memory = 0.0;
        clearMembersExceptMemory();
    }

    public void clearMembersExceptMemory () {
        leftText = new StringBuilder();
        rightText = new StringBuilder();
        left = null;
        right = null;
        result = null;
        operator = null;
        displayContent = new StringBuilder();
        calculatorState = new PendingLeftOperandState(this);
    }

    public void setToInitialState() {
        calculatorState = new InitialState(this);
    }

    public void pressClearButton() {
        calculatorState = new InitialState(this);
    }


    @Override
    public String toString() {
        return displayContent.toString();
    }

    public void clearLeftText() {
        leftText = new StringBuilder();
    }

    public void appendToLeftText(String text) {
        leftText.append(text);
    }

    public boolean isLeftOperandEmpty() {
        return leftText.length() == 0;
    }

    public boolean isRightOperandEmpty() {
        return rightText.length() == 0;
    }

    public boolean leftOperandTextContainsDecimal() {
        return leftText.toString().contains(".");
    }

    public void appendToLeftOperandText(char button) {
        leftText.append(button);
    }

    public void buildLeftOperandValue() {
        left = Double.parseDouble(leftText.toString());
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public void setRightText(String s) {
        rightText = new StringBuilder(s);
    }

    public void buildRightOperandValue() {
        right = Double.parseDouble(rightText.toString());
    }

    public void calculateResult() throws Exception {
        OperationStrategy operationStrategy = StrategiesFactory.createStrategy(operator);
        result = operationStrategy.execute(left, right);
    }

    public void buildOperandValues() {
        buildLeftOperandValue();
        buildRightOperandValue();
    }

    public String getRightText() {
        return rightText.toString();
    }

    public char getOperator() {
        return operator;
    }

    public Double getLeft() {
        return left;
    }

    public void setLeft(Double left) {
        this.left = left;
    }

    public Double getRight() {
        return right;
    }

    public void setRight(Double right) {
        this.right = right;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public void buildLeftOperandText() {
        leftText = new StringBuilder(getLeftAsText());
    }

    public void buildRightOperandText() {
        rightText = new StringBuilder(right.toString());
    }

    public void buildOperandTexts() {
        buildLeftOperandText();
        buildRightOperandText();
    }

    public void clearMemory() { //MC
        memory = 0.0;
    }

    public void addToMemory(Double number) { //M+
        memory += number;
    }

    public void subtractFromMemory(Double number) { //M-
        memory -= number;
    }

    public void setMemory(double memory) { //MS
        this.memory = memory;
    }

    public Double getMemory() { //MR
        return memory;
    }

    public void pressMemorySaveButton() {
        calculatorState.pressMSButton();
    }

    public void pressMemoryClearButton() {
        calculatorState.pressMCButton();
    }

    public void pressMemoryAddButton() {
        calculatorState.pressMPlusButton();
    }

    public void pressMemorySubtractButton() {
        calculatorState.pressMMinusButton();
    }

    public void pressMemoryRecallButton() {
        calculatorState.pressMRButton();
    }

    public void clearLeft() {
        clearLeftText();
        left = null;
    }

    public CalculatorContextMemento saveMemento() {
        return new CalculatorContextMemento(calculatorState.createEmptyState(),
                new StringBuilder(leftText),
                left != null ? Double.valueOf(left) : null,
                operator != null ? Character.valueOf(operator) : null,
                new StringBuilder(rightText),
                right != null ? Double.valueOf(right) : null,
                result != null ? Double.valueOf(result) : null,
                memory != null ? Double.valueOf(memory) : null,
                new StringBuilder(displayContent));
    }

    public void restore(CalculatorContextMemento memento) {
        if (memento != null) {
            this.leftText = new StringBuilder(memento.leftText);
            this.left = memento.left != null ? Double.valueOf(memento.left) : null;
            this.operator = memento.operator != null ? Character.valueOf(memento.operator) : null;
            this.rightText = new StringBuilder(memento.rightText);
            this.right = memento.right!=null ? Double.valueOf(memento.right) : null;
            this.result = memento.result!=null ? Double.valueOf(memento.result) : null;
            this.memory = memento.memory!=null ? Double.valueOf(memento.memory) : null;
            this.displayContent = new StringBuilder(memento.displayContent);
            calculatorState = memento.calculatorState;
            calculatorState.setCalculatorContext(this);
        }
    }

    public StringBuilder getDisplayContent() {
        return displayContent;
    }

    public void appendResult() {
        displayContent.append("=");
        String resultAsString = (result - result.intValue()==0.0) ? String.valueOf(result.intValue()) : result.toString();
        displayContent.append(resultAsString);
    }

    public void buildDisplay() {
        String resultAsString = (result - result.intValue()==0.0) ? String.valueOf(result.intValue()) : result.toString();
        displayContent.append(leftText).append(operator).append(rightText).append("=").append(resultAsString);
    }

    public void clearDisplay() {
        displayContent = new StringBuilder();
    }

    public void clearRight() {
        rightText = new StringBuilder();
        right = null;
    }

    public String getLeftAsText() {
        return ((left - left.intValue()) == 0.0) ? String.valueOf(left.intValue()) : left.toString();
    }

    public String getLeftText() {
        return leftText.toString();
    }

    public void setLeftText(String newLeftText) {
        leftText = new StringBuilder(newLeftText);
    }

    public void pressChangeSignButton() {
        calculatorState.pressChangeSignButton();
    }
}
