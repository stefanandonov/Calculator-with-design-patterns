package mk.ukim.finki.Homework3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CategoryLeaf extends BasicCategory implements CategoryComponent  {

    public CategoryLeaf(String categoryName) {
        super(categoryName);
    }

    @Override
    public void printBooks(int indent) {
        super.printBooks(indent);
    }

    @Override
    public void addBook(String categoryName, Book book) {
        super.addBook(categoryName, book);
    }

    @Override
    public void addCategory(CategoryComponent categoryComponent) {
        return ;
    }

    @Override
    public Book searchByTitle(String title) {
        return books.stream().filter(book -> book.title.equals(title)).findFirst().orElse(null);
    }

    @Override
    public List<Book> searchByAuthor(String authorName) {
        return books.stream()
                .filter(book ->
                        book.authors.stream()
                                .map(author -> author.firstName + author.lastName)
                                .anyMatch(name -> name.toLowerCase().contains(authorName))
                )
                .collect(Collectors.toList());
    }

    @Override
    public Book searchByISBN(String ISBN) {
        return books.stream().filter(book -> book.ISBN.equals(ISBN)).findFirst().orElse(null);
    }
}
