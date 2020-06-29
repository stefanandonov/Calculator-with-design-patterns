package mk.ukim.finki.command;

public class TurnTvOff extends Command {


    public TurnTvOff(Television device) {
        super(device);
    }

    @Override
    public TVMemento execute() {
        return this.television.off();
    }

    @Override
    public String description() {
        return "TURN TV OFF command";
    }
}
