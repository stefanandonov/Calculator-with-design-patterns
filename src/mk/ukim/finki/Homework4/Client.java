package mk.ukim.finki.Homework4;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class Client {

    private static void printCard(Card card) {
        System.out.println(String.format("Card title:%s\nCard body:%s\nCard is sent to:\n%s\n",
                card.getTitle(),
                card.getBody(),
                card.getAddresses().size() == 0 ? "none" : String.join("\n", card.getAddresses())));
    }

    public static void main(String[] args) {


        Card newYearCard = new NewYearCard();

        Card christmasCard = new ChristmasCard();
        Card christmasCardWithImages = new ImagesCard(christmasCard, List.of(new File("/home/stefan5andonov/work/DesignPatterns/src/mk/ukim/finki/Homework4/card.jpg")));
        Card newYearCardWithImages = new ImagesCard(newYearCard, List.of(new File("/home/stefan5andonov/work/DesignPatterns/src/mk/ukim/finki/Homework4/card.jpg")));

        Card graduationCard = new ImagesCard
                (new ImagesCard(new PersonalizedCard("Dear friend, Congratulations on your graduation!", "Happy graduation!"),
                        List.of(new File("/home/stefan5andonov/work/DesignPatterns/src/mk/ukim/finki/Homework4/graduation_cap.jpeg"))),
                        List.of(new File("/home/stefan5andonov/work/DesignPatterns/src/mk/ukim/finki/Homework4/finki.png")));


        printCard(newYearCard);
        printCard(christmasCard);
        printCard(newYearCardWithImages);
        printCard(christmasCardWithImages);
        printCard(graduationCard);
    }
}
