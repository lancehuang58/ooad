package game.handler;

import game.Slot;
import game.spirite.Hero;
import game.spirite.Water;

public class HeroWaterCollision extends CollisionHandler {

    public HeroWaterCollision(CollisionHandler next) {
        super(next);
    }

    @Override
    public boolean match(Slot src, Slot target) {
        boolean hw = src.getSprite().getName().equals("H")
                && target.getSprite().getName().equals("W");
        boolean wh = src.getSprite().getName().equals("W")
                && target.getSprite().getName().equals("H");
        return hw || wh;
    }

    @Override
    public void doHandle(Slot src, Slot target) {
        if (src.getSprite() instanceof Hero) {
            Hero sprite = (Hero) src.getSprite();
            sprite.setHp(sprite.getHp() + 10);
            target.setSprite(sprite);
            src.setSprite(null);
        }

        if (src.getSprite() instanceof Water) {
            src.setSprite(null);
            Hero hero = (Hero) target.getSprite();
            hero.setHp(hero.getHp() + 10);
        }

    }
}
