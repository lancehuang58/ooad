package game;

import lombok.extern.slf4j.Slf4j;

import java.util.EnumSet;

@Slf4j
public class PokerDeck extends AbstractDeck {

    public PokerDeck(int size) {
        super(size);
    }


    public AbstractDeck initCards() {
        for (int i = 2; i < 15; i++) {
            for (Suit suit : EnumSet.allOf(Suit.class)) {
                this.cards.add(Card.of(Rank.fromValue(i), suit));
            }
        }
        return this;
    }


    public void print() {
        for (int i = 0; i < cards.size(); i++) {
            log.info("{}", cards.get(i));
        }
    }
}
