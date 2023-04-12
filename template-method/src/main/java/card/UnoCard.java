package card;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UnoCard implements Card {
	private Color color;
	private int number;
}
