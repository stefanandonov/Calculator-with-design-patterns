package mk.ukim.finki.Homework3;

import java.util.List;

public interface CategoryComponent {

    void printBooks (int indent);
    void addBook (String categoryName, Book book);
    void addCategory (CategoryComponent categoryComponent);
    Book searchByTitle (String title);
    List<Book> searchByAuthor (String authorName);
    Book searchByISBN (String ISBN);

}
