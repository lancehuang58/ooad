package game;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

public class Client {

    InputDataParser parser = new InputDataParser(Constant.FILE_PATH);
    Big2 game = new Big2();

    public void initGame() throws IOException {
        game.initDeck(parser.nextLine());
        game.addPlayer(parser.nextLine());
        game.addPlayer(parser.nextLine());
        game.addPlayer(parser.nextLine());
        game.addPlayer(parser.nextLine());
        game.dispatchCard();
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.initGame();
        client.playGame();
    }


    private void playGame() throws IOException {
        String input = parser.nextLine();
        while (!StringUtils.isBlank(input)) {
            game.nextInput(input);
            input = parser.nextLine();
        }
    }
}
