package game;

import java.util.Collection;

public abstract class Player {


    protected Collection<Card> cards;

    protected Card currentCard;

    protected boolean exchangeCardUsed;

    protected Player exchangeCardPlayer;

    protected int exchangeCardCount;

    private int score;

    private String name;

    protected void setName(String name) {
        this.name = name;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    protected abstract Card showCard();

    public abstract boolean exchangeCard();

    protected abstract Card selectCard();

    protected abstract String naming();

    public void scoreIncremental() {
        this.score++;
    }


    protected void doExchange(Player src, Player target) {
        Card tmp = src.showCard();
        src.setCurrentCard(target.showCard());
        target.setCurrentCard(tmp);
        this.exchangeCardPlayer = target;
        this.exchangeCardCount = 1;
    }

    private void setCurrentCard(Card card) {
        this.currentCard = card;
    }

    public abstract Player selectTargetPlayer();


    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }
}
