package mk.ukim.finki.Homework5;

import java.time.Duration;
import java.time.LocalDateTime;

public class PowerTest {

    public static void main(String[] args) {
        for (int i=10;i<1000;i++) {
            LocalDateTime start = LocalDateTime.now();
            double result = Math.pow(7, i);
            LocalDateTime end = LocalDateTime.now();
            System.out.println(result + " " + Duration.between(start, end).toNanos());
        }
    }
}
