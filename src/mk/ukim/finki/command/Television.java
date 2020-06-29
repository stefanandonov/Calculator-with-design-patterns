package mk.ukim.finki.command;

public class Television implements TVOriginator {

    boolean on;
    int volume;

    Television() {
        on = false;
        volume = 0;
    }

    public Television(boolean on, int volume) {
        this.on = on;
        this.volume = volume;
    }


    public TVMemento on() {
        if (!on) {
            on = true;
            System.out.println("TV is now on");
        }
        else {
            System.out.println("TV is already on.");
        }

        return createMemento();
    }


    public TVMemento off() {
        if (on) {
            on = false;
            System.out.println("TV is now off");
        }
        else {
            System.out.println("TV is already off");
        }

        return createMemento();
    }


    public TVMemento volumeUp() {
        if (volume!=100) {
            volume++;
            System.out.println("Volume up+1 : " + volume);
        }
        else {
            System.out.println("Volume is at max! Can't increase more");
        }

        return createMemento();
    }

    public TVMemento volumeDown() {
        if (volume!=0) {
            volume--;
            System.out.println("Volume down-1: " + volume);
        }
        else  {
            System.out.println("Volume is at min! Can't decrease more");
        }

        return createMemento();
    }

    @Override
    public void setMemento(TVMemento memento) {
        this.volume = memento.getVolume();
        this.on = memento.isOn();
        System.out.println(this.toString());
    }

    @Override
    public TVMemento createMemento() {
        return new TVMemento(on,volume);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Television{");
        sb.append("on=").append(on);
        sb.append(", volume=").append(volume);
        sb.append('}');
        return sb.toString();
    }
}
