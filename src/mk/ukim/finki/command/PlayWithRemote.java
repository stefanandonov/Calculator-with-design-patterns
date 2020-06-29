package mk.ukim.finki.command;

public class PlayWithRemote {

    public static void main(String[] args) {
        Television device = new Television();

        DeviceButton onButton = new DeviceButton(new TurnTvOn(device));
        DeviceButton volumeUpButton = new DeviceButton(new TurnVolumeUp(device));

        onButton.press();
        onButton.undo();
        onButton.redo();

        volumeUpButton.press();
        volumeUpButton.press();
        volumeUpButton.press();
        volumeUpButton.press();
        volumeUpButton.undo();
        volumeUpButton.redo();
        volumeUpButton.undo();
        volumeUpButton.undo();
        volumeUpButton.redo();
        volumeUpButton.undo();
        volumeUpButton.undo();
        volumeUpButton.undo();
        volumeUpButton.undo();
        //System.out.println(device);

    }
}
