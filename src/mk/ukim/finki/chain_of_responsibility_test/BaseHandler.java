package mk.ukim.finki.chain_of_responsibility_test;

public abstract class BaseHandler implements Handler {

    Handler next;

    public BaseHandler(Handler next) {
        this.next = next;
    }

    @Override
    public void setNext(Handler handler) {
        this.next=handler;
    }


}
