package game.spirite;

public class Hero extends Sprite {

    private int hp;

    public int getHp() {
        return hp;
    }

    public Hero() {
        this.hp = 30;
    }

    @Override
    public String getName() {
        return "H";
    }

    public void setHp(int i) {
        this.hp = i;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    public String getNameWithHp() {
        return getName() + "(" + getHp() + ")";
    }
}
