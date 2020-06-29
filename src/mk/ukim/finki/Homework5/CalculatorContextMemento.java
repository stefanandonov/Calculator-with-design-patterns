package mk.ukim.finki.Homework5;

import mk.ukim.finki.Homework5.states.calculator_context_states.CalculatorState;

public class CalculatorContextMemento {

    CalculatorState calculatorState;
    StringBuilder leftText;
    Double left;
    Character operator;
    StringBuilder rightText;
    Double right;
    Double result;
    Double memory;
    StringBuilder displayContent;

    public CalculatorContextMemento(CalculatorState calculatorState, StringBuilder leftText, Double left,
                                    Character operator, StringBuilder rightText, Double right, Double result,
                                    Double memory, StringBuilder displayContent) {
        this.calculatorState = calculatorState;
        this.leftText = leftText;
        this.left = left;
        this.operator = operator;
        this.rightText = rightText;
        this.right = right;
        this.result = result;
        this.memory = memory;
        this.displayContent = displayContent;
    }


}
