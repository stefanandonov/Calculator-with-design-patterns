package mk.ukim.finki.iterator;

import java.util.stream.IntStream;

public class TestClass {

    public static void main(String[] args) {
        int [] array = IntStream.range(5,100).toArray();
        IntArray intArray = new IntArray(array);
        Iterator<Integer> evenIntegerIterator = intArray.createIterator();

        for (evenIntegerIterator.first();!evenIntegerIterator.isDone();evenIntegerIterator.next()) {
            System.out.println(evenIntegerIterator.currentItem());
        }


    }
}
