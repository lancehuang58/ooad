package game;

import java.util.EnumSet;

public class UnoDeck extends AbstractDeck {
    public UnoDeck() {
        super(40);
    }

    @Override
    public AbstractDeck initCards() {
        for (int i = 0; i < 10; i++) {
            for (Color color : EnumSet.allOf(Color.class)) {
                this.cards.add(Card.of(color, i + 1));
            }
        }
        return this;
    }

}
