package mk.ukim.finki.Homework5.buttons;

import mk.ukim.finki.Homework5.commands.Command;

public class Button {

    Command command;

    public Button(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public void pressButton () {
        command.execute();
    }
}
