package game;

import net.bytebuddy.utility.RandomString;

import java.util.Scanner;

public class HumanPlayer extends Player {

    @Override
    String selfNaming() {
//        System.out.println("please input your name: ");
//        Scanner scanner = new Scanner(System.in);
//        return scanner.next();
        return RandomString.make(5);
    }
}
