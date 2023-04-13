package waterball.card;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.EnumUtils;
@ToString
@Getter
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(of = {"rank", "suit"})
public class Card {
    private Rank rank;
    private Suit suit;
    public static Card of(String r, String s){
        return new Card(Rank.fromValue(r), EnumUtils.getEnum(Suit.class, s));
    }
}
