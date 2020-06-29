package mk.ukim.finki.command;

public class TurnTvOn extends Command {

    public TurnTvOn(Television device) {
        super(device);
    }

    @Override
    public TVMemento execute() {
        return this.television.on();
    }

    @Override
    public String description() {
        return "TURN TV ON command";
    }
}
