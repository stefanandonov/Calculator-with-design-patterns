package mk.ukim.finki.Homework3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryComposite extends BasicCategory implements CategoryComponent {

    List<CategoryComponent> subcategories;

    public CategoryComposite(String categoryName) {
        super(categoryName);
        this.subcategories = new ArrayList<>();
    }

    @Override
    public void printBooks(int indent) {
        super.printBooks(indent);
        subcategories.forEach(subcategory -> subcategory.printBooks(indent + 1));
    }

    @Override
    public void addBook(String categoryName, Book book) {
        super.addBook(categoryName, book);
        subcategories.forEach(categoryComponent -> categoryComponent.addBook(categoryName, book));

    }

    @Override
    public void addCategory(CategoryComponent categoryComponent) {
        this.subcategories.add(categoryComponent);
    }

    @Override
    public Book searchByTitle(String title) {
        return books.stream().
                filter(book -> book.title.equals(title))
                .findFirst()
                .orElseGet(() -> subcategories.stream()
                        .map(subcategory -> subcategory.searchByTitle(title))
                        .findFirst()
                        .orElse(null));
    }

    @Override
    public List<Book> searchByAuthor(String authorName) {
        List<Book> foundBooks = books.stream()
                .filter(book ->
                        book.authors.stream()
                                .map(author -> author.firstName + author.lastName)
                                .anyMatch(name -> name.toLowerCase().contains(authorName))
                )
                .collect(Collectors.toList());

        List<Book> booksInSubcategories = subcategories.stream()
                .flatMap(subcategory -> subcategory.searchByAuthor(authorName).stream())
                .collect(Collectors.toList());

        foundBooks.addAll(booksInSubcategories);
        return foundBooks;
    }

    @Override
    public Book searchByISBN(String ISBN) {
        return books.stream().
                filter(book -> book.ISBN.equals(ISBN))
                .findFirst()
                .orElseGet(() -> subcategories.stream()
                        .map(subcategory -> subcategory.searchByISBN(ISBN))
                        .findFirst()
                        .orElse(null));
    }
}
