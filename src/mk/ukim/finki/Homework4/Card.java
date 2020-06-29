package mk.ukim.finki.Homework4;

import java.util.ArrayList;
import java.util.List;

public class Card {
    protected String body;
    protected String title;
    protected List<String> addresses;

    Card() {
        this.addresses = new ArrayList<>();
    }

    public Card(String body, String title) {
        this.body = body;
        this.title = title;
        this.addresses = new ArrayList<>();
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addAddress (String address) {
        this.addresses.add(address);
    }
}
