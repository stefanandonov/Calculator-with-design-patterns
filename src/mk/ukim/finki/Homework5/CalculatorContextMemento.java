package mk.ukim.finki.Homework5;

import mk.ukim.finki.Homework5.states.calculator_context_states.CalculatorState;
import mk.ukim.finki.Homework5.strategy.OperationStrategy;
import mk.ukim.finki.Homework5.strategy.StrategiesFactory;

public class CalculatorContextMemento {

    CalculatorState calculatorState;
    StringBuilder leftText;
    Double left;
    Character operator;
    OperationStrategy strategy;
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
        strategy = this.operator != null ? StrategiesFactory.createStrategy(this.operator) : null;
        this.rightText = rightText;
        this.right = right;
        this.result = result;
        this.memory = memory;
        this.displayContent = displayContent;
    }


}
