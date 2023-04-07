package deck;

import card.Color;
import card.UnoCard;

import java.util.ArrayList;
import java.util.EnumSet;

public class UnoDeck extends Deck<UnoCard> {

    public UnoDeck(int size) {
        super(size);
    }

    @Override
    public UnoDeck initCards() {
        this.cards = new ArrayList<>(40);
        for (int i = 0; i < 10; i++) {
            for (Color color : EnumSet.allOf(Color.class)) {
                cards.add(new UnoCard(color, i + 1));
            }
        }
        return this;
    }

    public void shuffleExcept(UnoCard currentCard) {
    }
}
