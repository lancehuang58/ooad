package waterball.card;

import java.util.ArrayList;
import java.util.List;

public class Deck extends ArrayList<Card> {
    public Deck(List<Card> list) {
        super(list);
    }

    public Card dispatchCard() {
        return this.remove(this.size() - 1);
    }

}
