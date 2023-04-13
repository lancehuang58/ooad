package waterball.player;

public class AiPlayer extends Player {

    private String name1;

    public AiPlayer(String name1) {
        this.name1 = name1;
    }

    @Override
    public String getName() {
        return name1;
    }
}
