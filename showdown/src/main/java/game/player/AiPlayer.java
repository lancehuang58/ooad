package game.player;

import game.Card;
import game.Player;

public class AiPlayer extends Player {


    public AiPlayer() {
        setName(naming());
    }

    @Override
    protected Card showCard() {
        //TODO:: select card randomly.
        return null;
    }

    @Override
    public boolean exchangeCard() {
        return false;
    }

    @Override
    protected Card selectCard() {
        return null;
    }

    @Override
    protected String naming() {
        //TODO::get name by random generation
        return null;
    }

    @Override
    public Player selectTargetPlayer() {
        return null;
    }
}
