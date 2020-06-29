package mk.ukim.finki.command;

import java.util.Stack;

public class DeviceButton {
    //Invoker

    Command command;
    static Stack<Command> undoCommands = new Stack<>();
    static Stack<TVMemento> undoMementos = new Stack<>();
    static Stack<Command> redoCommands = new Stack<>();
    static Stack<TVMemento> redoMementos = new Stack<>();

    public DeviceButton(Command command) {
        this.command = command;
        undoMementos.push(command.television.createMemento());
        undoCommands.push(command);
    }

    public void press () {
        TVMemento result = command.execute();
        undoCommands.push(command);
        undoMementos.push(result);
    }

    public void undo() {
        if (canUndo()) {
            Command undoCommand = undoCommands.pop();
            TVMemento undoMemento = undoMementos.pop();

            redoCommands.push(undoCommand);
            redoMementos.push(undoMemento);

            if (canUndo())
                undoCommand.television.setMemento(undoMementos.peek());
        }
    }

    public void redo() {
        if (canRedo()) {
            TVMemento redoMemento = redoMementos.pop();
            command.television.setMemento(redoMemento);
        }
    }

    public boolean canUndo () {
        return !undoCommands.empty();
    }

    public boolean canRedo() {
        return !redoCommands.empty();
    }
}

