package game;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Game game = new PokerGame();
        List<Player> players = game.initPlayers(4);
        AbstractDeck deck = game.createDeck().initCards().shuffle();
        game.playerDrawCard(players, deck, 13);
        Player winner = game.contest(players);
        System.out.println("winner is " + winner.getName());

        System.out.println("#####");

        Game game2 = new UnoGame();
        List<Player> players2 = game2.initPlayers(4);
        AbstractDeck deck2 = game2.createDeck().initCards().shuffle();
        game2.playerDrawCard(players2, deck2, 5);
        Player winner2 = game2.contest(players2);
        System.out.println("winner is " + winner2.getName());
    }
}
