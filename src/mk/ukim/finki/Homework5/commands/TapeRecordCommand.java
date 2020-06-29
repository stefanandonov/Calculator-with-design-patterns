package mk.ukim.finki.Homework5.commands;

import mk.ukim.finki.Homework5.CalculatorPaperTape;

public class TapeRecordCommand extends Command {

    CalculatorPaperTape tape;
    public TapeRecordCommand(CalculatorPaperTape tape) {

        this.tape = tape;
    }

    @Override
    public void execute() {
        tape.pressOnOffButton();
    }
}
