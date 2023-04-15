package game.handler;

import game.Slot;
import game.spirite.Hero;

public class HeroWaterCollision extends CollisionHandler {

    public HeroWaterCollision(CollisionHandler next) {
        super(next);
    }

    @Override
    public boolean match(Slot src, Slot target) {
        return src.getSprite().getName().equals("H")
                && target.getSprite().getName().equals("W");
    }

    @Override
    public void doHandle(Slot src, Slot target) {
        Hero sprite = (Hero) src.getSprite();
        sprite.setHp(sprite.getHp() + 10);
        target.setSprite(sprite);
        src.setSprite(null);
    }
}
