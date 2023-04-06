package game;

import net.bytebuddy.utility.RandomString;

public class AIPlayer extends Player {

    @Override
    String selfNaming() {
        return RandomString.make(5);
    }
}
