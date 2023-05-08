package game.card.pattern;


import game.card.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.*;
import java.util.stream.Collectors;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public abstract class CardPattern extends ArrayList<Card> {

    private CardPatternType cardPatternType;

    public Card getMaxOne() {
        return this.stream().max(Card.CARD_COMPARATOR).orElse(null);
    }

    public Card getMaxOfThree() {
        return this.stream().collect(Collectors.groupingBy(Card::getRank))
                .values().stream()
                .filter((cards -> cards.size() == 3))
                .flatMap(Collection::stream)
                .max(Card.CARD_COMPARATOR).orElse(null);
    }

    public String toString() {
        return String.format("%s %s", getName(), this.stream()
                .map(Card::toString).collect(Collectors.joining(" ")));
    }

    public abstract String getName();
}
