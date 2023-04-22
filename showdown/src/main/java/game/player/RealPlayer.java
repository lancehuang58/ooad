package game.player;

import java.util.List;
import java.util.Scanner;

public class RealPlayer extends Player {

    @Override
    public void naming() {
        System.out.println("please input your name: ");
        Scanner scanner = new Scanner(System.in);
        this.name = scanner.nextLine();
    }

    @Override
    protected Player decideExchangePlayer(List<Player> others) {
        System.out.println("please decide use exchange player : 1-3?");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        return others.get(i);
    }

    @Override
    protected boolean decideUseExchange() {
        System.out.println("please decide use exchange card or not : Y/N?");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        return s.equalsIgnoreCase("Y");
    }
}
