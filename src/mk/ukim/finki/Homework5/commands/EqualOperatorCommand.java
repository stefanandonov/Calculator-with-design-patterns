package mk.ukim.finki.Homework5.commands;

import mk.ukim.finki.Homework5.CalculatorContext;
import mk.ukim.finki.Homework5.CalculatorPaperTape;
import mk.ukim.finki.Homework5.CommandsHistory;

public class EqualOperatorCommand extends Command {

    CalculatorContext context;
    CommandsHistory history;
    CalculatorPaperTape tape;

    public EqualOperatorCommand(CalculatorContext calculator, CommandsHistory history, CalculatorPaperTape tape) {
        this.context = calculator;
        this.history = history;
        this.tape = tape;
    }

    @Override
    public void execute() {
        String displayLine = context.pressEqualButton();
        if (displayLine!=null)
            tape.addDisplayLine(displayLine);
        history.addMemento(context.saveMemento());
    }

    @Override
    public String toString() {
        return "=";
    }
}
