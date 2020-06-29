package mk.ukim.finki.chain_of_responsibility_test;

public interface Handler {
    void setNext (Handler handler);
    boolean handle (int a, int b, int result);
}
