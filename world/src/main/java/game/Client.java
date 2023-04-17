package game;

public class Client {

    public static void main(String[] args) {
        World world = new World();
        world.init();
        world.printSlots();
        world.run();
    }
}
