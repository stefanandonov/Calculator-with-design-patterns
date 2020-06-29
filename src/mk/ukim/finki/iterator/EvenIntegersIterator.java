package mk.ukim.finki.iterator;

public class EvenIntegersIterator implements Iterator<Integer> {

    IntArray intArray;
    int curr = 0;

    public EvenIntegersIterator(IntArray intArray) {
        this.intArray = intArray;
    }

    @Override
    public void first() {
        while (intArray.array[curr]%2!=0) {
            ++curr;
        }
    }

    @Override
    public void next() {
        for (;intArray.array[curr]%2==0;curr++);
    }

    @Override
    public boolean isDone() {
        return curr>intArray.array.length;
    }

    @Override
    public Integer currentItem() {
        return intArray.array[curr];
    }
}
