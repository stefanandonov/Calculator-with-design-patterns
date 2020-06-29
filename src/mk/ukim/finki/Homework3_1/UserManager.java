package mk.ukim.finki.Homework3_1;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class UserManager {

    Map<String, LibraryUser> users;

    public UserManager() {
        users = new HashMap<>();
    }

    public void addUser (LibraryUser libraryUser) {
        users.put(libraryUser.uuid, libraryUser);
    }

    public void removeUser (String userId) {
        users.remove(userId);
    }

    public void rentABook (LibraryUser libraryUser, Book book) {
        users.get(libraryUser.uuid).rentABook(book, LocalDateTime.now());
    }
}
