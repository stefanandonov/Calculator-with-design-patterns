package mk.ukim.finki.Homework3;

import java.time.LocalDateTime;
import java.util.List;

public class LibraryUser {
    String firstName;
    String lastName;
    String uuid;
    List<String> records;

    public LibraryUser(String firstName, String lastName, String uuid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.uuid = uuid;
    }

    public void rentABook (Book book, LocalDateTime dateTime) {
        records.add(String.format("%s has been rented at %s", book.toString(), dateTime.toString()));
    }

    public void printUserRecords () {
        records.forEach(System.out::println);
    }
}
