package mk.ukim.finki.memento;

public class Memento {
    int number;

    public Memento(int number) {
        this.number = number;
    }

    int getState() {
        return number;
    }
}
