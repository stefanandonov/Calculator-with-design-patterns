package mk.ukim.finki.command;

public class TurnVolumeDown extends Command {

    public TurnVolumeDown(Television device) {
       super(device);
    }

    @Override
    public TVMemento execute() {
        return this.television.volumeDown();
    }

    @Override
    public String description() {
        return "TURN TV VOLUME DOWN command";
    }
}
