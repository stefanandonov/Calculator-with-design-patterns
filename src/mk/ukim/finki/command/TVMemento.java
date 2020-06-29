package mk.ukim.finki.command;

public class TVMemento {

    boolean on;
    int volume;

    public TVMemento(boolean on, int volume) {
        this.on = on;
        this.volume = volume;
    }


    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setState (Television television) {
        on = television.on;
        volume = television.volume;
    }
}
