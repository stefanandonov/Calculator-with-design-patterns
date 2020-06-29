package mk.ukim.finki.Homework5;

import java.util.Stack;

public class CommandsHistory {

    Stack<CalculatorContextMemento> undoMementos;
    Stack<CalculatorContextMemento> redoMementos;
    boolean locked;

    public CommandsHistory() {
        undoMementos = new Stack<>();
        redoMementos = new Stack<>();
        locked = true;
    }

    public void addMemento (CalculatorContextMemento memento) {
        undoMementos.push(memento);
        locked = true;
    }

    public CalculatorContextMemento undo () {
        if (undoMementos.size()<2)
            return null;

        redoMementos.push(undoMementos.pop());
        locked = false;
        return undoMementos.peek();
    }

    public CalculatorContextMemento redo() {
        if (!locked && !redoMementos.isEmpty())
            return redoMementos.pop();
        else
            return null;

    }

    public void clearHistory() {
        undoMementos = new Stack<>();
        redoMementos = new Stack<>();
        locked = false;
    }
}
