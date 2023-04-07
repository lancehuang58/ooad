package game;

import card.Card;
import player.AiPlayer;
import player.Player;
import deck.Deck;

import java.util.ArrayList;
import java.util.List;

public abstract class Game<T extends Card> {

    List<Player<T>> players;

    public void initPlayers(int size) {
        this.players = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            players.add(new AiPlayer<>());
        }
    }

    public abstract Deck<T> createDeck();

    public abstract void dispatchCards();

    public abstract Player<T> contest();

}
