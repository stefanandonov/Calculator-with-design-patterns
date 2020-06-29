package mk.ukim.finki.Homework3_1;


public class PrintManagerAdapter implements NewPrintManager {

    PrintManager printManager;

    public PrintManagerAdapter(PrintManager printManager) {
        this.printManager = printManager;
    }


    @Override
    public void printNewCard(LibraryUser user, Book book) {

    }
}
