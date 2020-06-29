package mk.ukim.finki.uvid;

import java.util.*;
import java.util.stream.Collectors;

class Student{
    private String index;
    private List<Integer> points;

    public String getIndex() {
        return index;
    }

    public List<Integer> getPoints() {
        return points;
    }

    public Student(String index, List<Integer> points) {
        this.index = index;
        this.points = points;
    }

    public Double sumPoints(){
        return points.stream().mapToInt(i->i).sum()/10.0;
    }

    public int numLabs(){
        return points.size();
    }

    public String passed(){
        if(points.size()>=8)
            return "YES";
        else
            return "NO";
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", index, passed(), sumPoints());
    }
}

class LabExercises{
    private List<Student> students;

    public LabExercises() {
        students = new ArrayList<>();
    }

    public void addStudent (Student student){
        students.add(student);
    }

    public void printByAveragePoints (boolean ascending, int n){
        if(ascending)
            students.stream().sorted(Comparator.comparing(Student::sumPoints)
                    .thenComparing(Student::getIndex)).forEach(System.out::println);
        else
            students.stream().sorted(Comparator.comparing(Student::sumPoints)
                    .thenComparing(Student::getIndex).reversed()).forEach(System.out::println);
    }

    public List<Student> failedStudents (){

        return students.stream()
                .filter(student -> student.numLabs()<8)
                .sorted(Comparator.comparing(Student::getIndex).thenComparing(Student::sumPoints))
                .collect(Collectors.toList());
    }

    public Map<Integer,Double> getStatisticsByYear(){
        Map<String,List<Double>> byYear = new TreeMap<>();
        students.stream().filter(student -> student.numLabs()<8).forEach(student -> {
            byYear.putIfAbsent(student.getIndex().substring(0,1), new ArrayList<>());
            byYear.get(student.getIndex().substring(0,1)).add(student.sumPoints());
        });
        Map<Integer,Double> statistics = new TreeMap<>();
        byYear.entrySet().forEach(entry -> {
            statistics.put(Integer.parseInt(entry.getKey()), entry.getValue()
                    .stream().mapToDouble(Double::doubleValue).sum() / entry.getValue().size());
        });

        return statistics;
    }
}


public class LabExercisesTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LabExercises labExercises = new LabExercises();
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            String[] parts = input.split("\\s+");
            String index = parts[0];
            List<Integer> points = Arrays.stream(parts).skip(1)
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());

            labExercises.addStudent(new Student(index, points));
        }

        System.out.println("===printByAveragePoints (ascending)===");
        labExercises.printByAveragePoints(true, 100);
        System.out.println("===printByAveragePoints (descending)===");
        labExercises.printByAveragePoints(false, 100);
        System.out.println("===failed students===");
        labExercises.failedStudents().forEach(System.out::println);
        System.out.println("===statistics by year");
        labExercises.getStatisticsByYear().entrySet().stream()
                .map(entry -> String.format("%d : %.2f", entry.getKey(), entry.getValue()))
                .forEach(System.out::println);

    }
}