package mk.ukim.finki.Homework5.states.calculator_manager_states;

import mk.ukim.finki.Homework5.buttons.CalculatorButtons;
import mk.ukim.finki.Homework5.CalculatorManager;

public class CalculatingState extends CalculatorManagerState {
    public CalculatingState(CalculatorManager calculatorManager) {
        super(calculatorManager);
    }

    @Override
    public void pressProg() {
        calculatorManager.setCalculatorManagerState(new RecordingState(calculatorManager));
    }

    @Override
    public void pressRcl() {
        calculatorManager.clearCalculatorContext();
        this.calculatorManager.getProgram().recallSavedProgram();
    }

    @Override
    public void acceptKey(String keyStroke) {
        new CalculatorButtons(calculatorManager).getButton(keyStroke).pressButton();
    }
}
