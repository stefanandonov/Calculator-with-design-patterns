package mk.ukim.finki.Homework5.commands;

import mk.ukim.finki.Homework5.CalculatorContext;
import mk.ukim.finki.Homework5.CommandsHistory;

public class NumberAndDecimalCommand extends Command {

    Character character;
    CalculatorContext calculator;
    CommandsHistory history;

    public NumberAndDecimalCommand(CalculatorContext calculator, CommandsHistory history, Character character) {
        this.calculator = calculator;
        this.history = history;
        this.character = character;
    }

    @Override
    public void execute() {
        calculator.pressNumericOrDecimalButton(character);
        history.addMemento(calculator.saveMemento());
    }



    @Override
    public String toString() {
        return String.valueOf(character);
    }
}
