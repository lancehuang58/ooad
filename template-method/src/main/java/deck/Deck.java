package deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.concurrent.ThreadLocalRandom.current;

public abstract class Deck<T> {

    protected List<T> cards;

    public Deck(int size) {
        this.cards = new ArrayList<>(size);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public abstract Deck<T> initCards();

    public T drawCard() {
        return cards.remove(current()
                .nextInt(cards.size()));
    }

    public boolean isEmpty() {
        return this.cards.isEmpty();
    }

}
