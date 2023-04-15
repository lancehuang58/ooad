package game.handler;

import game.Slot;
import game.spirite.Fire;
import game.spirite.Hero;

public class HeroFireCollision extends CollisionHandler {

    public HeroFireCollision(CollisionHandler next) {
        super(next);
    }

    @Override
    public boolean match(Slot src, Slot target) {
        boolean hf = src.getSprite().getName().equals("H")
                && target.getSprite().getName().equals("F");
        boolean fh = src.getSprite().getName().equals("F")
                && target.getSprite().getName().equals("H");
        return hf | fh;
    }

    @Override
    public void doHandle(Slot src, Slot target) {

        if (src.getSprite() instanceof Hero) {
            Hero sprite = (Hero) src.getSprite();
            sprite.setHp(sprite.getHp() - 10);
            target.setSprite(sprite);
            src.setSprite(null);
        }

        if (src.getSprite() instanceof Fire) {
            src.setSprite(null);
            Hero hero = (Hero) target.getSprite();
            hero.setHp(hero.getHp() - 10);
        }

    }
}
