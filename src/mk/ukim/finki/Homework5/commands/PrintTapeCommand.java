package mk.ukim.finki.Homework5.commands;

import mk.ukim.finki.Homework5.CalculatorPaperTape;

public class PrintTapeCommand extends Command {

    CalculatorPaperTape tape;
    public PrintTapeCommand(CalculatorPaperTape tape) {
        this.tape = tape;
    }

    @Override
    public void execute() {
        tape.printAllRecords();
    }
}
