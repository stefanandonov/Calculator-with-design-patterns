package mk.ukim.finki.Homework5.states.calcilator_tape_states;

import mk.ukim.finki.Homework5.CalculatorPaperTape;

public class CalculatorPaperTapeOffState extends CalculatorPaperTapeState {

    public CalculatorPaperTapeOffState(CalculatorPaperTape calculatorPaperTape) {
        super(calculatorPaperTape);
    }

    @Override
    public void addDisplayLine(String displayLine) {
        //do nothing
    }

    @Override
    public void pressOnOffButton() {
        this.calculatorPaperTape.setState(new CalculatorPaperTapeOnState(this.calculatorPaperTape));
    }
}
