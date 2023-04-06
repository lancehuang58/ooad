package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractDeck {

    protected List<Card> cards;
    private int size;

    public AbstractDeck(int size) {
        this.cards = new ArrayList<>();
        this.size = size;
    }

    public AbstractDeck shuffle() {
        Collections.shuffle(cards);
        return this;
    }

    ;

    protected abstract AbstractDeck initCards();

    public Card drawCard() {
        return cards.remove(ThreadLocalRandom.current().nextInt(cards.size()));
    }
}
