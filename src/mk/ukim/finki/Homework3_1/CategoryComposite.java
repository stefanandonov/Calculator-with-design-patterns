package mk.ukim.finki.Homework3_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryComposite implements CategoryComponent {

    String categoryName;
    List<CategoryComponent> components;

    public CategoryComposite(String categoryName) {
        this.categoryName = categoryName;
        this.components = new ArrayList<>();
    }

    @Override
    public void printBooks(int indent) {
        StringBuilder indentString = new StringBuilder();
        for (int i=0;i<indent;i++) {
            indentString.append("---");
        }
        System.out.print(indentString);
        System.out.println(categoryName+":");
        components.forEach(subcategory -> subcategory.printBooks(indent + 1));
    }

    public void addCategoryComponent (CategoryComponent categoryComponent) {
        this.components.add(categoryComponent);
    }

    public void removeCategoryComponent (CategoryComponent categoryComponent) {
        this.components.remove(categoryComponent);
    }

    public List<CategoryComponent> getCategoryComponents () {
        return null;
    }

    public Book searchByTitle(String title) {

        return components.stream().map(categoryComponent -> categoryComponent.searchByTitle(title)).findFirst().orElse(null);
//        return books.stream().
//                filter(book -> book.title.equals(title))
//                .findFirst()
//                .orElseGet(() -> components.stream()
//                        .map(subcategory -> subcategory.searchByTitle(title))
//                        .findFirst()
//                        .orElse(null));
    }

    @Override
    public List<Book> searchByAuthor(String authorName) {

        return this.components.stream()
                .map(categoryComponent -> categoryComponent.searchByAuthor(authorName))
                .filter(list -> !list.isEmpty())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public Book searchByISBN(String ISBN) {
        return this.components.stream().map(categoryComponent -> categoryComponent.searchByISBN(ISBN)).findFirst().orElse(null);
    }


//    public List<Book> searchByAuthor(String authorName) {
//        List<Book> foundBooks = books.stream()
//                .filter(book ->
//                        book.authors.stream()
//                                .map(author -> author.firstName + author.lastName)
//                                .anyMatch(name -> name.toLowerCase().contains(authorName))
//                )
//                .collect(Collectors.toList());
//
//        List<Book> booksInSubcategories = components.stream()
//                .flatMap(subcategory -> subcategory.searchByAuthor(authorName).stream())
//                .collect(Collectors.toList());
//
//        foundBooks.addAll(booksInSubcategories);
//        return foundBooks;
//    }


//    public Book searchByISBN(String ISBN) {
//        return books.stream().
//                filter(book -> book.ISBN.equals(ISBN))
//                .findFirst()
//                .orElseGet(() -> components.stream()
//                        .map(subcategory -> subcategory.searchByISBN(ISBN))
//                        .findFirst()
//                        .orElse(null));
//    }
}
