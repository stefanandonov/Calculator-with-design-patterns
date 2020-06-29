package mk.ukim.finki.Homework3;

import java.util.List;
import java.util.UUID;

public class LibraryFacade {

    UserManager userManager;
    PrintManager printManager;
    BookCatalog bookCatalog;

    public LibraryFacade() {
        userManager = new UserManager();
        printManager = new PrintManagerAdapter(new UserDetailsExtractor());
        bookCatalog = new BookCatalog();
    }

    public void addBookToLibrary (String category, Book book) {
        bookCatalog.addBook(category,book);
    }

    public void addBookCategoryToLibrary (CategoryComponent categoryComponent) {
        bookCatalog.addCategory(categoryComponent);
    }

    public void registerUserToLibrary (String firstName, String lastName) {
        userManager.addUser(new LibraryUser(firstName, lastName, UUID.randomUUID().toString()));
    }

    public void unregisterUserFromLibrary (String userId) {
        userManager.removeUser(userId);
    }

    public void rentABookByTitle (String bookTitle, LibraryUser user) {
        Book book = bookCatalog.searchByTitle(bookTitle);
        if (book!=null) {
            userManager.rentABook(user,book);
            printManager.printCard(user,book);
        }
    }

    public void rentABookByISBN (String ISBN, LibraryUser user) {
        Book book = bookCatalog.searchByISBN(ISBN);
        if (book!=null) {
            userManager.rentABook(user,book);
            printManager.printCard(user,book);
        }
    }

    public void rentBooksByAuthor (String author, LibraryUser user) {
        List<Book> booksToRent = bookCatalog.searchByAuthor(author);
        if (!booksToRent.isEmpty()) {
            for (Book book : booksToRent) {
                userManager.rentABook(user,book);
                printManager.printCard(user,book);
            }
        }
    }


}
