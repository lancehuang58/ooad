package game.handler;

import game.Slot;

public class FireWaterCollision extends CollisionHandler {


    public FireWaterCollision(CollisionHandler next) {
        super(next);
    }

    @Override
    public boolean match(Slot src, Slot target) {
        boolean wf = src.getSprite().getName().equals("W") && target.getSprite().getName().equals("F");
        boolean fw = src.getSprite().getName().equals("F") && target.getSprite().getName().equals("W");
        return wf || fw;
    }

    @Override
    public void doHandle(Slot src, Slot target) {
        src.setSprite(null);
        target.setSprite(null);
    }
}
