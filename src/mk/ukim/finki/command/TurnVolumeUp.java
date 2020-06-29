package mk.ukim.finki.command;

public class TurnVolumeUp extends Command {

    public TurnVolumeUp(Television device) {
        super(device);
//        this.television = device;
    }

    @Override
    public TVMemento execute() {
        return this.television.volumeUp();
    }

    @Override
    public String description() {
        return "TURN TV VOLUME UP command";
    }
}
