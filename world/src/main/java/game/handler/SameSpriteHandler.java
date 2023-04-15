package game.handler;

import game.Slot;

public class SameSpriteHandler extends CollisionHandler {

    public SameSpriteHandler(CollisionHandler next) {
        super(next);
    }

    @Override
    public boolean match(Slot src, Slot target) {
        return src.getSprite().getName().equals(target.getSprite().getName());
    }

    @Override
    public void doHandle(Slot src, Slot target) {
        System.out.println("same sprite , move fail!");
    }
}
