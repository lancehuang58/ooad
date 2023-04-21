package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>(52);
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                //init card
            }
        }
    }

    public Card drawCard() {
        //TODO:: get one card in shuffled card collection
        return null;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

}
