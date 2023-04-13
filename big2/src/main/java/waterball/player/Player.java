package waterball.player;

import lombok.Getter;
import waterball.card.Card;

import java.util.Collections;

@Getter
public abstract class Player {
    private String name;
    private HandCard handCard;

    public Player() {
        this.name = getName();
        this.handCard = new HandCard();
    }

    public abstract String getName();

    public void addCard(Card dispatchCard) {
        handCard.add(dispatchCard);
    }

    public void sortHandCards() {
        Collections.sort(handCard);
    }

    public void printCards() {
        for (Card card : handCard) {
            System.out.printf("%s[%s]\t", card.getSuit().name(), card.getRank().getText());
        }
        System.out.println();
    }

    public Card deal() {
        return this.handCard.remove(0);
    }
}
