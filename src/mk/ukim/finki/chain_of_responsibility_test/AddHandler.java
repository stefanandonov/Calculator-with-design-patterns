package mk.ukim.finki.chain_of_responsibility_test;

public class AddHandler extends  BaseHandler {

    public AddHandler(Handler next) {
        super(next);
    }

    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }

    @Override
    public boolean handle(int a, int b, int result) {
        if (a+b==result)
            return true;
        else if (next!=null)
            return next.handle(a,b,result);
        else
            return false;
    }
}
