package mk.ukim.finki.Homework5.buttons;

import mk.ukim.finki.Homework5.CalculatorContext;
import mk.ukim.finki.Homework5.CalculatorManager;
import mk.ukim.finki.Homework5.CalculatorPaperTape;
import mk.ukim.finki.Homework5.CommandsHistory;
import mk.ukim.finki.Homework5.commands.*;

import java.util.HashMap;
import java.util.Map;

public class CalculatorButtons {
    Map<String, Button> buttonMap = new HashMap<>();

    public CalculatorButtons(CalculatorManager calculatorManager) {
        CalculatorContext context = calculatorManager.getContext();
        CommandsHistory history = calculatorManager.getHistory();
        CalculatorPaperTape tape = calculatorManager.getTape();
        for (int i = 0; i <= 9; i++)
            buttonMap.put(String.valueOf(i), new Button(new NumberAndDecimalCommand(context, history, Character.forDigit(i, 10))));

        buttonMap.put(".", new Button(new NumberAndDecimalCommand(context, history, '.')));

        String[] operators = {"+", "-", "*", "/"};

        for (String operator : operators)
            buttonMap.put(operator, new Button(new OperatorCommand(context, history, operator.charAt(0))));

        buttonMap.put("=", new Button(new EqualOperatorCommand(context, history, tape)));

        buttonMap.put("MS", new Button(new MemorySaveCommand(context, history)));
        buttonMap.put("M+", new Button(new MemoryAddCommand(context, history)));
        buttonMap.put("M-", new Button(new MemorySubtractCommand(context, history)));
        buttonMap.put("MR", new Button(new MemoryRecallCommand(context, history)));
        buttonMap.put("MC", new Button(new MemoryClearCommand(context, history)));
        buttonMap.put("UNDO", new Button(new UndoCommand(context, history)));
        buttonMap.put("REDO", new Button(new RedoCommand(context, history)));
        buttonMap.put("PROG", new Button(new ProgramCommand(calculatorManager)));
        buttonMap.put("RCL", new Button(new ProgramRecallCommand(calculatorManager)));
        buttonMap.put("T", new Button(new TapeRecordCommand(tape)));
        buttonMap.put("PT", new Button(new PrintTapeCommand(tape)));
        buttonMap.put("CLR", new Button(new ClearEverythingCommand(context, history, tape)));
        buttonMap.put("+/-", new Button(new ChangeSignCommand(context, history)));
    }


    public Button getButton(String button) {
        return buttonMap.getOrDefault(button, buttonMap.get("="));
    }
}
