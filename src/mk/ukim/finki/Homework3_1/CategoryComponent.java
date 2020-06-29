package mk.ukim.finki.Homework3_1;

import java.util.List;

public interface CategoryComponent {

    void printBooks(int indent);
    Book searchByTitle(String title);
    List<Book> searchByAuthor(String authorName);
    Book searchByISBN(String ISBN);

}
