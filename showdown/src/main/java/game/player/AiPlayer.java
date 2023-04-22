package game.player;

import net.bytebuddy.utility.RandomString;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AiPlayer extends Player {
    public AiPlayer() {
        naming();
    }

    @Override
    protected Player decideExchangePlayer(List<Player> players) {
        int i = ThreadLocalRandom.current().nextInt(players.size());
        Player targetPlayer = players.get(i);
//        System.out.println("target player " + targetPlayer.getName());
        return targetPlayer;
    }

    @Override
    protected boolean decideUseExchange() {
        boolean b = ThreadLocalRandom.current().nextBoolean();
//        System.out.println("decide use exchange " + b);
        return b;
    }

    @Override
    public void naming() {
        this.name = RandomString.make(5);
    }
}
