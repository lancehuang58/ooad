package game;

import game.spirite.Fire;
import game.spirite.Hero;
import game.spirite.Sprite;
import game.spirite.Water;

import java.util.Arrays;
import java.util.List;

public class SpriteGenerator extends RandomObjectGenerator<Sprite> {

    public SpriteGenerator(int size) {
        super(size);
    }

    @Override
    List<Class<? extends Sprite>> getClazz() {
        return Arrays.asList(Water.class, Fire.class, Hero.class);
    }
}
