package waterball.player;

import java.util.Scanner;

public class HumanPlayer extends Player {

    @Override
    public String getName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input your name: ");
        return scanner.next();
    }
}
