package game.card;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CardTest {


    @Test
    void test_sort_order() {

        List<Card> list = new ArrayList<>();
        list.add(Card.of(Rank.K, Suit.HEART));
        list.add(Card.of(Rank.J, Suit.HEART));
        list.add(Card.of(Rank._9, Suit.SPADE));
        list.add(Card.of(Rank._9, Suit.HEART));

        list.sort(Card.cardComparator);
        System.out.println(list);
    }
}