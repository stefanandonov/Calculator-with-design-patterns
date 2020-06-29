package mk.ukim.finki.iterator;

public interface Iterator<T> {
    void first();
    void next();
    boolean isDone();
    T currentItem();
}
