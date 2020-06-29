package mk.ukim.finki.iterator;

public class IntArray implements Aggregate {

    int[] array;

    public IntArray(int[] array) {
        this.array = array;
    }



    @Override
    public Iterator<Integer> createIterator() {
        return new EvenIntegersIterator(this);
    }
}
