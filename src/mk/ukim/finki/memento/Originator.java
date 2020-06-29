package mk.ukim.finki.memento;

public class Originator {

    int number; //state

    public Originator(int number) {
        this.number = number;
    }

    public Memento save() {
        return new Memento(number);
    }

    public void restore (Memento memento) {
        this.number = memento.number;
    }
}
