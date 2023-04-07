package player;

import card.Card;
import net.bytebuddy.utility.RandomString;

public class AiPlayer<T extends Card> extends Player<T> {

    public AiPlayer() {
        this.hand = new Hand();
        naming();
    }

    public void naming() {
        setName(RandomString.make(5));
    }
}
