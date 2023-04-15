package game;

import game.handler.*;
import game.spirite.Hero;
import game.spirite.Sprite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class World {

    public static final int INITIAL_CAPACITY = 30;
    private final List<Slot> slots;

    public World() {
        slots = new ArrayList<>(INITIAL_CAPACITY);
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            slots.add(new Slot());
        }
    }

    public void init() {
        SpriteGenerator generator = new SpriteGenerator(10);
        for (Sprite sprite : generator) {
            slotsAddSprite(sprite);
        }
        Collections.shuffle(slots);
    }

    private void slotsAddSprite(Sprite sprite) {
        for (Slot slot : slots) {
            if (slot.getSprite() == null) {
                slot.setSprite(sprite);
                break;
            }
        }
    }

    public void run() {
        while (true) {
            System.out.println("\n please input command: (e : quit/ p: print)");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();

            if (input.equals(("p"))) {
                printSlots();
                continue;
            }

            if (input.equals("e")) {
                break;
            }

            System.out.println("input index of src: ");
            String x = scanner.next();
            System.out.println("input index of target: ");
            String y = scanner.next();
            move(parseInt(x), parseInt(y));
        }
    }


    public void move(int x1, int x2) {
        Slot slot = slots.get(x1);
        Slot slot2 = slots.get(x2);
        if (slot2.getSprite() == null) {
            slot2.setSprite(slot.getSprite());
            slot.setSprite(null);
            slots.set(x1, slot);
            slots.set(x2, slot2);
            System.out.println("move successfully!");
            return;
        }

        CollisionHandler collisionHandler =
                new SameSpriteHandler(
                        new HeroWaterCollision(
                                new FireWaterCollision(
                                        new HeroFireCollision(null))));
        collisionHandler.handle(slot, slot2);
        printSlots();
    }

    public void printSlots() {
        for (int i = 0; i < slots.size(); i++) {
            Slot slot = slots.get(i);
            if (slot.getSprite() != null) {
                System.out.printf("[%d - %s],", i,
                        slot.getSprite().getName().equals("H")
                                ? ((Hero) slot.getSprite()).getNameWithHp() :
                                slot.getSprite().getName());
            }
        }
    }
}
