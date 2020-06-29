package mk.ukim.finki.chain_of_responsibility_test;

public class MultiplyHandler extends BaseHandler {

    public MultiplyHandler(Handler next) {
        super(next);
    }

    @Override
    public boolean handle(int a, int b, int result) {
        if (a*b==result)
            return true;
        else if (next!=null) {
            return next.handle(a,b,result);
        }
        else
            return false;
    }
}
