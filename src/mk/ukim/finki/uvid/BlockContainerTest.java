package mk.ukim.finki.uvid;

//package ukim.finki.np.Ispitni;

import java.util.*;
import java.util.stream.Collectors;

public class BlockContainerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int size = scanner.nextInt();
        BlockContainer<Integer> integerBC = new BlockContainer<Integer>(size);
        scanner.nextLine();
        Integer lastInteger = null;
        for(int i = 0; i < n; ++i) {
            int element = scanner.nextInt();
            lastInteger = element;
            integerBC.add(element);
        }
        System.out.println("+++++ Integer Block Container +++++");
        System.out.println(integerBC);
        System.out.println("+++++ Removing element +++++");
        integerBC.remove(lastInteger);
        System.out.println("+++++ Sorting container +++++");
        integerBC.sort();
        System.out.println(integerBC);
        BlockContainer<String> stringBC = new BlockContainer<String>(size);
        String lastString = null;
        for(int i = 0; i < n; ++i) {
            String element = scanner.next();
            lastString = element;
            stringBC.add(element);
        }
        System.out.println("+++++ String Block Container +++++");
        System.out.println(stringBC);
        System.out.println("+++++ Removing element +++++");
        stringBC.remove(lastString);
        System.out.println("+++++ Sorting container +++++");
        stringBC.sort();
        System.out.println(stringBC);
    }
}

// Вашиот код овде
class BlockContainer <T extends Comparable<T>>{
    int N;
    List<TreeSet<T>> blocks;//constant time for each block,  + log for block elements

    public BlockContainer(int n) {
        N = n;
        blocks = new ArrayList<>();
    }

    public void add(T a) {
        if(blocks.size() == 0){//if is empty
            TreeSet<T> blockSet = new TreeSet<T>();
            blockSet.add(a);
            blocks.add(blockSet);
        }
        if(blocks.get(blocks.size()-1).size() < N){//for the last one
            blocks.get(blocks.size()-1).add(a);
        }
        else {
            TreeSet<T> newBlock = new TreeSet<>();
            newBlock.add(a);
            blocks.add(newBlock);
        }
    }


    public boolean remove(T a) {
        // boolean REMOVED = blocks.get(blocks.lastIndexOf(blocks).remove(a);
        boolean REMOVED = blocks.get(blocks.size()-1).remove(a);
        if(blocks.get(blocks.size()-1).size() == 0){
            blocks.remove(blocks.size()-1);
        }
        return REMOVED;
    }

    public void sort() {

        TreeSet<T> containerElements = blocks.stream().flatMap(Collection::stream).collect(Collectors.toCollection(TreeSet::new));

        BlockContainer<T> newBlockContainer = new BlockContainer<>(this.N);
        containerElements.forEach(newBlockContainer::add);
        this.blocks = newBlockContainer.blocks;
    }

    @Override
    public String toString(){


        return blocks.stream()
                .map(block -> String.format("[%s]", block.stream().map(Object::toString).collect(Collectors.joining(", "))))
                .collect(Collectors.joining(", "));
    }
}