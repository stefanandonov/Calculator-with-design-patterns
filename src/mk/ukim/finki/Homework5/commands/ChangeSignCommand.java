package mk.ukim.finki.Homework5.commands;

import mk.ukim.finki.Homework5.CalculatorContext;
import mk.ukim.finki.Homework5.CommandsHistory;

public class ChangeSignCommand extends Command {

    CalculatorContext context;
    CommandsHistory history;

    public ChangeSignCommand(CalculatorContext context, CommandsHistory history) {
        super();
        this.context = context;
        this.history = history;
    }

    @Override
    public void execute() {
        context.pressChangeSignButton();
        history.addMemento(context.saveMemento());
    }

    @Override
    public String toString() {
        return "+/-";
    }
}
