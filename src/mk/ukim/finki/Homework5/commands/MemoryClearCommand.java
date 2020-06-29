package mk.ukim.finki.Homework5.commands;

import mk.ukim.finki.Homework5.CalculatorContext;
import mk.ukim.finki.Homework5.CommandsHistory;

public class MemoryClearCommand extends Command {

    CalculatorContext calculator;
    CommandsHistory history;

    public MemoryClearCommand(CalculatorContext calculator, CommandsHistory history) {
        this.calculator = calculator;
        this.history = history;
    }

    @Override
    public void execute() {
        calculator.pressMemoryClearButton();
        history.addMemento(calculator.saveMemento());
    }

    @Override
    public String toString() {
        return "MC";
    }
}
