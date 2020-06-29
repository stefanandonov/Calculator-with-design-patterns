package mk.ukim.finki.Homework5;

import mk.ukim.finki.Homework5.states.calculator_manager_states.CalculatingState;
import mk.ukim.finki.Homework5.states.calculator_manager_states.CalculatorManagerState;

public class CalculatorManager {
    CalculatorContext context;
    CalculatorManagerState calculatorManagerState;
    CommandsHistory history;
    CalculatorPaperTape tape;
    CalculatorProgram program;

    public CalculatorManager() {
        calculatorManagerState = new CalculatingState(this);
        context = new CalculatorContext();
        history = new CommandsHistory();
        program = new CalculatorProgram();
        tape = new CalculatorPaperTape();
    }

    public String acceptKey(String keyStroke) {
        calculatorManagerState.acceptKey(keyStroke);
        return context.toString();
    }

    public CalculatorProgram getProgram() {
        return program;
    }

    public void setProgram(CalculatorProgram program) {
        this.program = program;
    }

    public CalculatorManagerState getCalculatorManagerState() {
        return calculatorManagerState;
    }


    public void setCalculatorManagerState(CalculatorManagerState calculatorManagerState) {
        this.calculatorManagerState = calculatorManagerState;
    }

    public void clearCalculatorContext() {
        this.context.clearMembersExceptMemory();
        this.context.clearDisplay();
    }


    public String getMemory() {
        return String.format("Memory: %.4f",context.getMemory());
    }

    public String getProgramString() {
        return program.toString();
    }

    public String getTapeString() {
        return tape.toString();
    }

    public CalculatorContext getContext() {
        return context;
    }

    public CommandsHistory getHistory() {
        return history;
    }

    public CalculatorPaperTape getTape() {
        return tape;
    }
}
