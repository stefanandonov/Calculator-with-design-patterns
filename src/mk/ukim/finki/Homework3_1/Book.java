package mk.ukim.finki.Homework3_1;

import java.util.List;

public class Book {
    String title;
    String ISBN;
    String description;
    List<Author> authors;
    Publisher publisher;

    public Book(String title, String ISBN, String description, List<Author> authors, Publisher publisher) {
        this.title = title;
        this.ISBN = ISBN;
        this.description = description;
        this.authors = authors;
        this.publisher = publisher;
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("title='").append(title).append('\'');
        sb.append(", ISBN='").append(ISBN).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", authors=").append(authors);
        sb.append(", publisher=").append(publisher);
        sb.append('}');
        return sb.toString();
    }
}
