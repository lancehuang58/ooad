package game.card;

public enum Suit {
    CLUB, DIAMOND, HEART, SPADE;

    public int getSuitValue() {
        return this.ordinal();
    }
}
