package mk.ukim.finki.Homework5;

import mk.ukim.finki.Homework5.commands.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorProgram {

    List<Command> commands;
    private static final int MAX_SIZE = 30;

    CalculatorProgram() {
        commands = new ArrayList<>();
    }

    public void addCommand (Command command) {
        if (commands.size()!=MAX_SIZE)
            commands.add(command);
    }

    public void recallSavedProgram () {
        for (Command c : commands)
            c.execute();
        commands = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("Program: %s", commands.stream().map(Object::toString).collect(Collectors.joining("")));
    }
}
