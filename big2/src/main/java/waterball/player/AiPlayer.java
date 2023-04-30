package waterball.player;

public class AiPlayer extends Player {

    private final String name;

    public AiPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
