package mk.ukim.finki.Homework5.states.calculator_manager_states;

import mk.ukim.finki.Homework5.buttons.CalculatorButtons;
import mk.ukim.finki.Homework5.CalculatorManager;
import mk.ukim.finki.Homework5.buttons.Button;

public class RecordingState extends CalculatorManagerState {
    public RecordingState(CalculatorManager calculatorManager) {
        super(calculatorManager);
    }

    @Override
    public void pressProg() {
        calculatorManager.setCalculatorManagerState(new CalculatingState(calculatorManager));
    }

    @Override
    public void pressRcl() {

    }

    @Override
    public void acceptKey(String keyStroke) {
        if (keyStroke.equals("PROG")) {
            pressProg();
        }
        else {
            Button button = new CalculatorButtons(calculatorManager).getButton(keyStroke);
            calculatorManager.getProgram().addCommand(button.getCommand());
        }
    }


}
