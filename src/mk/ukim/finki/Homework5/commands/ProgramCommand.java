package mk.ukim.finki.Homework5.commands;

import mk.ukim.finki.Homework5.CalculatorManager;

public class ProgramCommand extends Command {

    CalculatorManager calculatorManager;

    public ProgramCommand(CalculatorManager calculatorManager) {
        this.calculatorManager = calculatorManager;
    }

    @Override
    public void execute() {
        calculatorManager.getCalculatorManagerState().pressProg();
    }
}
