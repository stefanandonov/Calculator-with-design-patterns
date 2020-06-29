package mk.ukim.finki.Homework3;

import java.util.ArrayList;
import java.util.List;

public abstract class BasicCategory {
    String categoryName;
    List<Book> books;

    public BasicCategory(String categoryName) {
        this.categoryName = categoryName;
        this.books = new ArrayList<>();
    }

    void printBooks (int indent) {
        StringBuilder indentString = new StringBuilder();
        StringBuilder spacesString = new StringBuilder();
        for (int i=0;i<indent;i++) {
            indentString.append("---");
            spacesString.append("   ");
        }
        System.out.print(indentString);
        System.out.println(categoryName+":");
        books.forEach(book -> System.out.println(spacesString.toString() + book));
    }

    public void addBook(String categoryName, Book book) {
        if (this.categoryName.equals(categoryName))
            books.add(book);
    }
}
