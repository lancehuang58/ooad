package game;

import game.player.Player;

public class ExchangeHand {

	private int round;

	private Player targetPlayer;

	public Player getTargetPlayer() {
		return targetPlayer;
	}

	public void setTargetPlayer(Player targetPlayer) {
		this.targetPlayer = targetPlayer;
	}

	public ExchangeHand() {
		round = 3;
	}

	public void roundDown() {
		round--;
	}

	public int getRound() {
		return round;
	}
}
