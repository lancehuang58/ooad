package player;

import card.Card;
import lombok.ToString;

@ToString
public abstract class Player<T extends Card> {

    protected Hand<T> hand;

    private String name;

    private int score;

    public Hand<T> getHand() {
        return hand;
    }

    public T showCard() {
        return hand.remove(0);
    }

    public abstract void naming();

    public void addCard(T card) {
        this.hand.add(card);
    }

    public void scoreIncremental() {
        this.score++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

}
