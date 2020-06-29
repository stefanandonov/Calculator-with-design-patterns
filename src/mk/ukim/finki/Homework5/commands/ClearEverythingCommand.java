package mk.ukim.finki.Homework5.commands;

import mk.ukim.finki.Homework5.CalculatorContext;
import mk.ukim.finki.Homework5.CalculatorPaperTape;
import mk.ukim.finki.Homework5.CommandsHistory;

public class ClearEverythingCommand extends Command {

    CalculatorContext context;
    CommandsHistory history;
    CalculatorPaperTape tape;

    public ClearEverythingCommand(CalculatorContext context, CommandsHistory history, CalculatorPaperTape tape) {
        this.context = context;
        this.history = history;
        this.tape = tape;
    }

    @Override
    public void execute() {
        context.clearMembers();
        history.clearHistory();
        tape.clearTape();
    }
}
