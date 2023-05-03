package game;

import game.card.Card;
import game.card.Rank;
import game.card.Suit;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class InputDataParserTest {

    @Test
    void test_parse_input_to_deck() throws IOException {
        InputDataParser parser = new InputDataParser(Constant.FILE_PATH);
        String s = parser.nextLine();
        Deck deck = new Deck(s);
        Card firstCard = deck.deal();
        assertEquals(Rank.K, firstCard.getRank());
        assertEquals(Suit.C, firstCard.getSuit());
    }

    @Test
    void test_get_next_line() throws IOException {
        InputDataParser parser = new InputDataParser(Constant.FILE_PATH);
        String s = parser.nextLine();
        assertNotNull(s);
        assertEquals(parser.nextLine(), "水球");
    }
}