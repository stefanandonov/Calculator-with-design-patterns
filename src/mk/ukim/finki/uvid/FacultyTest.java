package mk.ukim.finki.uvid;

import java.io.InputStream;
import java.util.*;
import java.util.stream.IntStream;

class Activity {
    int maxPoints;
    int weight;

    public Activity(int maxPoints, int weight) {
        this.maxPoints = maxPoints;
        this.weight = weight;
    }

    public double scalePoints(int points) {
        return (points * 1.0) / maxPoints * weight;
    }
}

class StudentRecord implements Comparable<StudentRecord> {
    String id;
    List<Integer> points;
    double totalPoints;
    int grade;

    public StudentRecord(String id, List<Integer> points) {
        this.id = id;
        this.points = points;
    }

    public void calculatePointsAndGrades(List<Activity> activities) {
        IntStream.range(0, activities.size()).forEach(i -> totalPoints += activities.get(i).scalePoints(points.get(i)));

        if (totalPoints < 50)
            grade = 5;
        else if (totalPoints < 60)
            grade = 6;
        else if (totalPoints < 70)
            grade = 7;
        else if (totalPoints < 80)
            grade = 8;
        else if (totalPoints < 90)
            grade = 9;
        else
            grade = 10;
    }

    @Override
    public int compareTo(StudentRecord studentRecord) {
        int first = Integer.compare(this.grade, studentRecord.grade);
        if (first == 0) {
            int second = Double.compare(this.totalPoints, studentRecord.totalPoints);
            if (second == 0)
                return this.id.compareTo(studentRecord.id);
            else
                return second;
        } else
            return first;
    }
}

class Course {
    String name;
    List<Activity> activityList;
    int credits;
    TreeSet<StudentRecord> studentRecordSet = new TreeSet<>();

    public Course() {
        activityList = new ArrayList<>();
    }

    public Course(String name, List<Activity> activityList, int credits) {
        this.name = name;
        this.activityList = activityList;
        this.credits = credits;
    }

    public void addStudentRecord(StudentRecord studentRecord) {
        studentRecordSet.add(studentRecord);
    }
}


class Faculty {
    Map<String, Course> coursesMap = new TreeMap<>();

    void readRecords(InputStream is) {
        Scanner sc = new Scanner(is);
        boolean readNewCourse = true;


        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String [] parts = line.split(",");

        }
    }
}

public class FacultyTest {
}
