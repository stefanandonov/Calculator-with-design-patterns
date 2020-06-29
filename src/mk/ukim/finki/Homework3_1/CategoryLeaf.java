package mk.ukim.finki.Homework3_1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryLeaf extends Book implements CategoryComponent {


    public CategoryLeaf(String title, String ISBN, String description, List<Author> authors, Publisher publisher) {
        super(title, ISBN, description, authors, publisher);
    }

    @Override
    public void printBooks(int indent) {
        StringBuilder spacesString = new StringBuilder();
        for (int i=0;i<indent;i++) {
            spacesString.append("   ");
        }
        System.out.println(spacesString+super.toString());
    }

    @Override
    public Book searchByTitle(String title) {
        if (this.title.equalsIgnoreCase(title))
            return this;
        else
            return null;
    }

    @Override
    public List<Book> searchByAuthor(String authorName) {
        List<Book> result = new ArrayList<>();
        if (this.authors.stream().map(author -> author.lastName.toLowerCase()).collect(Collectors.toList()).contains(authorName.toLowerCase()) ||
                this.authors.stream().map(author -> author.firstName.toLowerCase()).collect(Collectors.toList()).contains(authorName.toLowerCase()))
            result.add(this);

        return result;
    }

    @Override
    public Book searchByISBN(String ISBN) {
        if (this.ISBN.equalsIgnoreCase(ISBN))
            return this;
        else
            return null;
    }


//    @Override
//    public void printBooks(int indent) {
//        super.printBooks(indent);
//    }
//
//    @Override
//    public void addBook(String categoryName, Book book) {
//        super.addBook(categoryName, book);
//    }

//    @Override
//    public void addCategory(CategoryComponent categoryComponent) {
//        return ;
//    }
//
//    @Override
//    public Book searchByTitle(String title) {
//        return books.stream().filter(book -> book.title.equals(title)).findFirst().orElse(null);
//    }
//
//    @Override
//    public List<Book> searchByAuthor(String authorName) {
//        return books.stream()
//                .filter(book ->
//                        book.authors.stream()
//                                .map(author -> author.firstName + author.lastName)
//                                .anyMatch(name -> name.toLowerCase().contains(authorName))
//                )
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public Book searchByISBN(String ISBN) {
//        return books.stream().filter(book -> book.ISBN.equals(ISBN)).findFirst().orElse(null);
//    }
}
