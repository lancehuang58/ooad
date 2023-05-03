package game;


import game.card.Card;

import java.util.ArrayList;
import java.util.List;

public class HandCards extends ArrayList<Card> {

	public void remove(List<Card> cards) {
		this.removeAll(cards);
	}
}
