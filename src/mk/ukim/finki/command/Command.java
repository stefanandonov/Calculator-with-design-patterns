package mk.ukim.finki.command;

public abstract class Command {
    Television television;

    public Command(Television television) {
        this.television = television;
    }

    public abstract TVMemento execute ();
    public abstract String description();
}
