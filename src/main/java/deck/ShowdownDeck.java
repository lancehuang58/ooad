package deck;

import card.Rank;
import card.ShowDownCard;
import card.Suit;

import java.util.EnumSet;

public class ShowdownDeck extends Deck<ShowDownCard> {

    public ShowdownDeck(int size) {
        super(size);
    }

    @Override
    public ShowdownDeck initCards() {
        for (int i = 2; i < 15; i++) {
            for (Suit suit : EnumSet.allOf(Suit.class)) {
                cards.add(new ShowDownCard(Rank.fromValue(i), suit));
            }
        }
        System.out.println("total card size "+ cards.size());
        return this;
    }
}
