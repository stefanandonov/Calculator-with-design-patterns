package mk.ukim.finki.Homework5.commands;

import mk.ukim.finki.Homework5.CalculatorContext;
import mk.ukim.finki.Homework5.CommandsHistory;

public class OperatorCommand extends Command {

    Character operator;
    CalculatorContext calculator;
    CommandsHistory history;

    public OperatorCommand(CalculatorContext calculator, CommandsHistory history, Character operator) {
        this.calculator = calculator;
        this.history = history;
        this.operator = operator;
    }

    @Override
    public void execute() {

        calculator.pressOperatorButton(operator);
        history.addMemento(calculator.saveMemento());
    }

    @Override
    public String toString() {
        return String.valueOf(operator);
    }
}
