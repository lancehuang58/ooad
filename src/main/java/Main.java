import card.ShowDownCard;
import card.UnoCard;
import game.Game;
import game.ShowDown;
import game.Uno;
import player.Player;

public class Main {

    public static void main(String[] args) {

        showdown();

//        unoGame();
    }

    private static void unoGame() {
        Game<UnoCard> game = new Uno();
        game.initPlayers(4);
        game.createDeck().initCards().shuffle();
        game.dispatchCards();
        Player<UnoCard> winner = game.contest();
        System.out.println("winner is " + winner.getName());
    }

    private static void showdown() {
        Game<ShowDownCard> game = new ShowDown();
        game.initPlayers(4);
        game.createDeck().initCards().shuffle();
        game.dispatchCards();
        Player<ShowDownCard> winner = game.contest();
        System.out.println("winner is " + winner.getName());
    }
}
