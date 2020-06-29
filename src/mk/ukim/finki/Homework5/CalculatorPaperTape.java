package mk.ukim.finki.Homework5;

import mk.ukim.finki.Homework5.states.calcilator_tape_states.CalculatorPaperTapeOffState;
import mk.ukim.finki.Homework5.states.calcilator_tape_states.CalculatorPaperTapeOnState;
import mk.ukim.finki.Homework5.states.calcilator_tape_states.CalculatorPaperTapeState;

import java.util.ArrayList;
import java.util.List;

public class CalculatorPaperTape {

    List<String> tape;
    CalculatorPaperTapeState state;

    CalculatorPaperTape() {
        state = new CalculatorPaperTapeOnState(this);
        tape = new ArrayList<>();
    }

    public void addDisplayLine (String displayLine) {
        state.addDisplayLine(displayLine);
    }

    public void appendToTape (String line) {
        tape.add(line);
    }


    public void pressOnOffButton() {
        state.pressOnOffButton();
    }

    public void setState(CalculatorPaperTapeState calculatorPaperTapeState) {
        this.state = calculatorPaperTapeState;
    }

    public void printAllRecords() {
        System.out.println(tape.toString());
    }

    public String toString () {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        tape.forEach(line -> sb.append(line).append("<br>"));
        sb.append("</html>");
        return sb.toString();
    }

    public void clearTape() {
        tape = new ArrayList<>();
    }
}
