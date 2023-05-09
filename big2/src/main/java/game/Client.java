package game;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

public class Client {

  InputDataParser parser = new InputDataParser(Constant.FILE_PATH);
  Big2 game = new Big2();

  public static void main(String[] args) throws IOException {
    Client client = new Client();
    client.playGame();
  }

  private void initGame() throws IOException {
    game.initDeck(parser.nextLine());
    game.addPlayer(parser.nextLine());
    game.addPlayer(parser.nextLine());
    game.addPlayer(parser.nextLine());
    game.addPlayer(parser.nextLine());
    game.dispatchCard();
  }

  private void playGame() throws IOException {
    initGame();
    String input = parser.nextLine();
    while (!StringUtils.isBlank(input)) {
      game.takeTurn(input);
      input = parser.nextLine();
    }
  }
}
