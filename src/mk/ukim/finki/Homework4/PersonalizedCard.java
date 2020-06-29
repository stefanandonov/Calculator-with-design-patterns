package mk.ukim.finki.Homework4;

public class PersonalizedCard extends Card {

    private String newBody;
    private String newTitle;

    public PersonalizedCard(String body, String title) {
        this.newBody = body;
        this.newTitle = title;
    }

    @Override
    public String getBody() {
        return newBody;
    }

    @Override
    public String getTitle() {
        return newTitle;
    }
}
