package mk.ukim.finki.Homework3_1;

import java.util.List;
import java.util.UUID;

public class LibraryFacade {

    UserManager userManager;
    NewPrintManager printManager;
    BookCatalog bookCatalog;

    public LibraryFacade() {
        userManager = new UserManager();
        printManager = new PrintManagerAdapter(new PrintManager());
        bookCatalog = new BookCatalog();
    }



    public void addBookCategoryToLibrary (CategoryComposite categoryComposite) {
        bookCatalog.addCategory(categoryComposite);
    }

    public void updateCategory (CategoryComposite newCategoryComposite, String categoryName){

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
            printManager.printNewCard(user,book);
        }
    }

    public void rentABookByISBN (String ISBN, LibraryUser user) {
        Book book = bookCatalog.searchByISBN(ISBN);
        if (book!=null) {
            userManager.rentABook(user,book);
            printManager.printNewCard(user,book);
        }
    }

    public void rentBooksByAuthor (String author, LibraryUser user) {
        List<Book> booksToRent = bookCatalog.searchByAuthor(author);
        if (!booksToRent.isEmpty()) {
            for (Book book : booksToRent) {
                userManager.rentABook(user,book);
                printManager.printNewCard(user,book);
            }
        }
    }


}
