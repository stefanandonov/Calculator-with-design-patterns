package mk.ukim.finki.Homework4;

public abstract class CardDecorator extends Card{

    Card card;

    public CardDecorator(Card card) {
        super();
        this.card = card;
    }
}
