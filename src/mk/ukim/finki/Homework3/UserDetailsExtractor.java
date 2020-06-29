package mk.ukim.finki.Homework3;

public class UserDetailsExtractor {

    public void printUserDetails(LibraryUser user) {

        System.out.println("User first name: " + user.firstName);
        System.out.println("User last name: " + user.lastName);
        System.out.println("User ID: " + user.uuid);
        System.out.println(String.format("The user has previously rented %d books", user.records.size()));

    }
}
