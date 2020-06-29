package mk.ukim.finki.Homework3_1;

public class Author {
    String firstName;
    String lastName;
    int yearOfBirth;

    public Author(String firstName, String lastName, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Author{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", yearOfBirth=").append(yearOfBirth);
        sb.append('}');
        return sb.toString();
    }
}
