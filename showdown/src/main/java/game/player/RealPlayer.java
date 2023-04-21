package game.player;

import game.Card;
import game.Player;

public class RealPlayer extends Player {

    public RealPlayer() {
        setName(naming());
    }

    @Override
    protected Card showCard() {

        this.currentCard = selectCard();

        if (this.exchangeCardCount == 3) {
            doExchange(this, this.exchangeCardPlayer);
            this.exchangeCardCount = 0;
        }

        if(!exchangeCardUsed){
            if (exchangeCard()) {
                doExchange(this, selectTargetPlayer());
            }
        }

        return currentCard;
    }



    @Override
    public boolean exchangeCard() {
        //TODO:: decide exchange card by player input

        return false;
    }

    @Override
    protected Card selectCard() {
        //TODO:: select card by user input
        return null;
    }

    @Override
    protected String naming() {
        //TODO:: get name by user input
        return null;
    }

    @Override
    public Player selectTargetPlayer() {
        //TODO:: select target player by user input
        return null;
    }
}
