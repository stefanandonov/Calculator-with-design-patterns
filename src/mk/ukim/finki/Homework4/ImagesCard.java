package mk.ukim.finki.Homework4;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class ImagesCard extends Card {

    Card card;
    private List<File> images;

    public ImagesCard(Card card, List<File> images) {
        this.card = card;
        this.images = images;
    }

    @Override
    public String getBody() {
        return card.getBody() + "\n" + images.stream().map(File::toString).collect(Collectors.joining("\n"));
    }

    @Override
    public String getTitle() {
        return card.getTitle();
    }


}
