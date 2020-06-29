package mk.ukim.finki.uvid;

import java.util.Collection;
import java.util.List;

class GenericExample  {

    static double differenceOfSum (Collection<? extends Number> c1 , Collection<? extends Number> c2) {
        return c1.stream().mapToDouble(Number::doubleValue).sum() - c2.stream().mapToDouble(Number::doubleValue).sum();
    }
}

public class GenericsTest {

    public static void main(String[] args) {

    }
}
