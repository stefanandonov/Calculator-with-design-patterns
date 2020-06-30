package mk.ukim.finki.Homework5.states.calculator_tape_states;

import mk.ukim.finki.Homework5.CalculatorPaperTape;

public class CalculatorPaperTapeOnState extends CalculatorPaperTapeState {
    public CalculatorPaperTapeOnState(CalculatorPaperTape calculatorPaperTape) {
        super(calculatorPaperTape);
    }

    @Override
    public void addDisplayLine(String displayLine) {
        calculatorPaperTape.appendToTape(displayLine);
    }

    @Override
    public void pressOnOffButton() {
        this.calculatorPaperTape.setState(new CalculatorPaperTapeOffState(this.calculatorPaperTape));
    }
}
