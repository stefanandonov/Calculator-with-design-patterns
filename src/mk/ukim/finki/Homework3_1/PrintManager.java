package mk.ukim.finki.Homework3_1;

public class PrintManager {

    public void printCard (LibraryUser user, Book book) {

        System.out.println(String.format("The user %s has rented the book %s", user.toString(), book.toString()));

    }
}
