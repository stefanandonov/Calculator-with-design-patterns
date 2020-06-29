package mk.ukim.finki.Homework3;



public class PrintManagerAdapter extends PrintManager {

    UserDetailsExtractor userDetailsExtractor;

    public PrintManagerAdapter(UserDetailsExtractor userDetailsExtractor) {
        this.userDetailsExtractor = userDetailsExtractor;
    }

    @Override
    public void printCard(LibraryUser user, Book book) {
        userDetailsExtractor.printUserDetails(user);
        super.printCard(user, book);
    }
}
