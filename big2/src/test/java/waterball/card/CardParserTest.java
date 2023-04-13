package waterball.card;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class CardParserTest {

    CardParser parser = new CardParser();

    @Test
    void test() throws IOException {
        String s = readFirstLineTest();
        Deck deck = parser.parseCard(s);
        Assertions.assertThat(deck).hasSize(52).containsExactly(Card.of("8", "S"), Card.of("9", "S"), Card.of("3", "S"), Card.of("J", "D"), Card.of("7", "S"), Card.of("3", "H"), Card.of("2", "C"), Card.of("9", "C"), Card.of("2", "H"), Card.of("7", "D"), Card.of("K", "S"), Card.of("6", "C"), Card.of("3", "C"), Card.of("4", "D"), Card.of("7", "H"), Card.of("A", "C"), Card.of("A", "D"), Card.of("K", "D"), Card.of("4", "H"), Card.of("8", "D"), Card.of("4", "C"), Card.of("10", "H"), Card.of("A", "H"), Card.of("10", "S"), Card.of("Q", "H"), Card.of("5", "H"), Card.of("4", "S"), Card.of("5", "D"), Card.of("9", "H"), Card.of("8", "H"), Card.of("10", "C"), Card.of("6", "S"), Card.of("A", "S"), Card.of("3", "D"), Card.of("5", "S"), Card.of("9", "D"), Card.of("Q", "D"), Card.of("K", "H"), Card.of("Q", "C"), Card.of("J", "H"), Card.of("10", "D"), Card.of("2", "S"), Card.of("6", "H"), Card.of("K", "C"), Card.of("J", "S"), Card.of("7", "C"), Card.of("Q", "S"), Card.of("6", "D"), Card.of("2", "D"), Card.of("J", "C"), Card.of("8", "C"), Card.of("5", "C")

        );
    }

    String readFirstLineTest() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/test.data");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        return bufferedReader.readLine();
    }
}