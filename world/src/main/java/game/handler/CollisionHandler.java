package game.handler;

import game.Slot;

public abstract class CollisionHandler {

    private final CollisionHandler next;

    public CollisionHandler(CollisionHandler next) {
        this.next = next;
    }

    public void handle(Slot src, Slot target) {
        if (match(src, target)) {
            doHandle(src, target);
            return;
        }
        if (next != null) {
            next.handle(src, target);
        }
    }

    public abstract boolean match(Slot src, Slot target);

    abstract void doHandle(Slot src, Slot target);

}
