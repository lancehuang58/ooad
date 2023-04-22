package game.player;

import game.ExchangeHand;
import game.card.Card;
import game.HandCard;

import java.util.List;

public abstract class Player {

    protected String name;

    private int point;

    private boolean exchangeUsed;

    private HandCard handCard;

    ExchangeHand exchangeHand;

    public abstract void naming();

    protected abstract Player decideExchangePlayer(List<Player> others);

    protected abstract boolean decideUseExchange();

    public int getPoint() {
        return point;
    }

    public Player() {
        this.handCard = new HandCard();
    }

    public Card showCard() {
        return handCard.remove(0);
    }

    public void gainPoint() {
        point++;
    }

    public void addCard(Card card) {
        handCard.add(card);
    }

    public String getName() {
        return name;
    }

    public void setHandCard(HandCard handCard) {
        this.handCard = handCard;
    }

    public Card takeTurn(List<Player> others) {
        if (exchangeHand != null) {
            exchangeHand.roundDown();
            if (exchangeHand.getRound() == 0) {
                doExchange(exchangeHand.getTargetPlayer(), this);
                exchangeHand = null;
            }
        }

        if (exchangeUsed)
            return showCard();
        else {
            boolean useExchange = decideUseExchange();
            if (useExchange) {
                Player targetExchangePlayer = decideExchangePlayer(others);
                exchangeHand = new ExchangeHand();
                exchangeHand.setTargetPlayer(targetExchangePlayer);
                doExchange(this, targetExchangePlayer);
                this.exchangeUsed = true;
            }
            return showCard();
        }
    }

    public HandCard getHandCard() {
        return handCard;
    }


    private void doExchange(Player src, Player target) {
        HandCard tmp = src.getHandCard();
        src.setHandCard(target.getHandCard());
        target.setHandCard(tmp);
    }

}
