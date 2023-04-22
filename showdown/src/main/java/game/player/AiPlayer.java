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
        return players.get(i);
    }

    @Override
    protected boolean decideUseExchange() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    @Override
    public void naming() {
        this.name = RandomString.make(5);
    }
}
