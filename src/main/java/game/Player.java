package game;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Player {

    private final String name;
    private final Hand hand;
    private int score = 0;

    public Player() {
        this.name = selfNaming();
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    abstract String selfNaming();

    public void addCard(Card drawCard) {
        hand.add(drawCard);
    }

    public void printHand() {
        for (int i = 0; i < hand.size(); i++) {
            log.info("player {}, hand - {}", name, hand.get(i));
        }
    }

    public Card showCard() {
        return hand.remove(0);
    }

    public void scoreIncremental() {
        this.score++;
    }

    public int getScore() {
        return score;
    }
}
