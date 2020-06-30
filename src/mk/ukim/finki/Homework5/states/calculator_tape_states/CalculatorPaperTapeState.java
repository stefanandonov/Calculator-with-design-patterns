package mk.ukim.finki.Homework5.states.calculator_tape_states;

import mk.ukim.finki.Homework5.CalculatorPaperTape;

public abstract class CalculatorPaperTapeState {

    CalculatorPaperTape calculatorPaperTape;

    public CalculatorPaperTapeState(CalculatorPaperTape calculatorPaperTape) {
        this.calculatorPaperTape = calculatorPaperTape;
    }

    public abstract void addDisplayLine (String displayLine);

    public abstract void pressOnOffButton();
}
