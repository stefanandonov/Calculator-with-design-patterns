package mk.ukim.finki.uvid;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Generic table test
 */

class GenericTable <R extends Comparable<R>, V extends Number> {
    Map<R, List<V>> map = new TreeMap<>();


    public void addRow(R key, V[] values) {
        map.put(key, Arrays.stream(values).collect(Collectors.toList()));
    }

    double max (R key) {
        return map.getOrDefault(key, new ArrayList<>()).stream().mapToDouble(Number::doubleValue).max().orElse(0);
    }

    public String toString() {
        return map.entrySet().stream()
                .map(entry -> String.format("%s: %s",
                        entry.getKey(),
                        entry.getValue().stream()
                                .map(i -> String.format("%6.2f", i.doubleValue()))
                                .collect(Collectors.joining("\t")))
                ).collect(Collectors.joining("\n"));
    }
}
public class GenericTableTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GenericTable<String, Integer> stringTable = new GenericTable<>();
        GenericTable<Integer, Double> integerTable = new GenericTable<>();
        GenericTable<Key, Float> keyTable = new GenericTable<>();
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; ++i) {
            String[] parts = scanner.nextLine().split("\\s+");
            Integer[] values = new Integer[parts.length - 1];
            for (int j = 0; j < values.length; ++j) {
                values[j] = Integer.parseInt(parts[j + 1]);
            }
            stringTable.addRow(parts[0], values);
        }
        System.out.println("=== STRING TABLE ===");
        System.out.println(stringTable);
        String k = String.format("row%d", n / 2);
        System.out.printf("MAX (%s): %.2f\n", k, stringTable.max(k));
        n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; ++i) {
            String[] parts = scanner.nextLine().split("\\s+");
            Double[] values = new Double[parts.length - 1];
            for (int j = 0; j < values.length; ++j) {
                values[j] = Double.parseDouble(parts[j + 1]);
            }
            integerTable.addRow(Integer.parseInt(parts[0]), values);
        }
        System.out.println("=== INTEGER TABLE ===");
        System.out.println(integerTable);
        System.out.printf("MAX (%d): %.2f\n", n / 2, integerTable.max(n / 2));
        n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; ++i) {
            String[] parts = scanner.nextLine().split("\\s+");
            Float[] values = new Float[parts.length - 1];
            for (int j = 0; j < values.length; ++j) {
                values[j] = Float.parseFloat(parts[j + 1]);
            }
            String[] keys = parts[0].split(":");
            Key key = new Key(Integer.parseInt(keys[0]), keys[1]);
            keyTable.addRow(key, values);
        }
        System.out.println("=== KEY TABLE ===");
        System.out.println(keyTable);
        Key key = new Key(1, "a");
        System.out.printf("MAX (%s): %.2f\n", key, keyTable.max(key));
        scanner.close();

    }
}

class Key implements Comparable<Key> {
    int index;
    String name;

    public Key(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public int compareTo(Key o) {
        return Integer.compare(index, o.index);
    }

    @Override
    public String toString() {
        return String.format("%d (%s)", index, name);
    }
}

// your code here

