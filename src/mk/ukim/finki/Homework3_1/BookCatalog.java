package mk.ukim.finki.Homework3_1;

import java.util.ArrayList;
import java.util.List;

public class BookCatalog {

    List<CategoryComposite> categories;

    public BookCatalog() {
        categories = new ArrayList<>();
    }



    public void addCategory (CategoryComposite categoryComposite) {
        categories.add(categoryComposite);
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
