package mk.ukim.finki.Homework5.commands;

import mk.ukim.finki.Homework5.CalculatorContext;
import mk.ukim.finki.Homework5.CommandsHistory;

public class RedoCommand extends Command {

    CalculatorContext calculator;
    CommandsHistory history;

    public RedoCommand(CalculatorContext calculator, CommandsHistory history) {
        this.calculator = calculator;
        this.history = history;
    }

    @Override
    public void execute() {
        calculator.restore(history.redo());
    }
}
