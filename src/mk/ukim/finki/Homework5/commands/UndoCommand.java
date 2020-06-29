package mk.ukim.finki.Homework5.commands;

import mk.ukim.finki.Homework5.CalculatorContext;
import mk.ukim.finki.Homework5.CommandsHistory;

public class UndoCommand extends Command {

    CalculatorContext calculator;
    CommandsHistory history;

    public UndoCommand(CalculatorContext calculator, CommandsHistory commandsHistory) {
        this.calculator = calculator;
        this.history = commandsHistory;
    }

    @Override
    public void execute() {
        calculator.restore(history.undo());
    }
}
