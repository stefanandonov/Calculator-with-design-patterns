package mk.ukim.finki.Homework3;

import java.util.ArrayList;
import java.util.List;

public class BookCatalog {

    List<CategoryComponent> categories;

    public BookCatalog() {
        categories = new ArrayList<>();
    }

    public void addBook (String bookCategory, Book book) {
        categories.forEach(categoryComponent -> categoryComponent.addBook(bookCategory, book));
    }

    public void addCategory (CategoryComponent categoryComponent) {
        categories.add(categoryComponent);
    }

    Book searchByTitle (String title) {
        return null;
    }

    List<Book> searchByAuthor (String authorName) {
        return null;
    }

    Book searchByISBN (String ISBN) {
        return null;
    }
}
