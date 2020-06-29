package mk.ukim.finki.uvid;

import java.util.*;
import java.util.stream.Collectors;

public class GenericTest {

    public static <T extends Comparable<T>> Set<? extends Number> mapDifference(Map<T, ? extends Number> map1,
                                                                                Map<T, ? extends Number> map2) {

        return map1.entrySet()
                .stream()
                .filter(tEntry -> !map2.containsKey(tEntry.getKey()))
                .map(Map.Entry::getValue)
                .collect(Collectors.toCollection(TreeSet::new));

    }

    public static void main(String[] args) {

        int testCase;

        Scanner sc = new Scanner(System.in);

        testCase = sc.nextInt();

        if (testCase==1) {
            Map<String, Integer> map1 = new HashMap<>();
            Map<String, Double> map2 = new HashMap<>();
            int n = sc.nextInt();
            for (int i=0;i<n;i++) {
                String key = sc.next();
                int value = sc.nextInt();
                map1.put(key,value);
            }
            n = sc.nextInt();
            for (int i=0;i<n;i++) {
                String key = sc.next();
                double value = sc.nextDouble();
                map2.put(key,value);
            }

            System.out.println(mapDifference(map1,map2));
        }


    }
}
