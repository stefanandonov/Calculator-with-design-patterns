package mk.ukim.finki.uvid;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Swimmer {

    static Comparator<Swimmer> comparator = Comparator.comparingDouble(Swimmer::getTime).thenComparing(Swimmer::getName);
    String name;
    Double time;

    public static Swimmer of(String line) {
        String[] parts = line.split("\\s+");
        Double time = Double.parseDouble(parts[parts.length-1]);
        String name = Arrays.stream(parts).limit(parts.length-1).skip(1).collect(Collectors.joining(" "));
        return new Swimmer(name, time);
    }

    public Swimmer(String name, Double time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }


    public Double getTime() {
        return time;
    }

    public String toString() {
        return String.format("%30s %.2f", name, time);
    }
}

class SwimmingEvent {

    TreeSet<Swimmer> firstSemifinal;
    TreeSet<Swimmer> secondSemifinal;

    SwimmingEvent() {
        firstSemifinal = new TreeSet<>(Swimmer.comparator);
        secondSemifinal = new TreeSet<>(Swimmer.comparator);
    }

    public void read(InputStream in) {
        Scanner sc = new Scanner(in);
        String dummy = sc.nextLine();

        for (int i = 1; i <= 8; i++) {
            String line = sc.nextLine();
            firstSemifinal.add(Swimmer.of(line));
        }

        dummy = sc.nextLine();

        for (int i = 1; i <= 8; i++) {
            String line = sc.nextLine();
            secondSemifinal.add(Swimmer.of(line));
        }


    }

    public void printFinal(OutputStream out) {
        TreeSet<Swimmer> finalist = new TreeSet<>(Swimmer.comparator);

        for (int i = 0; i < 2; i++) {
            finalist.add(firstSemifinal.pollFirst());
            finalist.add(secondSemifinal.pollFirst());
        }

        firstSemifinal.addAll(secondSemifinal);

        for (int i = 0; i < 4; i++)
            finalist.add(firstSemifinal.pollFirst());

        TreeMap<Integer, Swimmer> finalistMap = new TreeMap<>();
        int[] order = {4, 5, 3, 6, 2, 7, 1, 8};

        Arrays.stream(order).forEach(i -> finalistMap.put(i, finalist.pollFirst()));

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
        pw.println("Final");
        finalistMap.entrySet().stream()
                .map(entry -> String.format("%d. %s", entry.getKey(), entry.getValue().toString()))
                .forEach(pw::println);

        pw.flush();

    }
}

public class Swimming {
    public static void main(String[] args) {
        SwimmingEvent swimmingEvent = new SwimmingEvent();
        swimmingEvent.read(System.in);
        swimmingEvent.printFinal(System.out);
    }
}

// your code here