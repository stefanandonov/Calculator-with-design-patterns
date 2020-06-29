package mk.ukim.finki.Homework5.commands;

import mk.ukim.finki.Homework5.CalculatorManager;

public class ProgramRecallCommand extends Command {

    CalculatorManager manager;

    public ProgramRecallCommand(CalculatorManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute() {
        this.manager.getCalculatorManagerState().pressRcl();
    }
}
