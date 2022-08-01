package ch1;

public class GuitarSpec {
    private final String model;
    private final Builder builder;
    private final Wood backWood;
    private final Wood topWood;
    private final Type type;
    private final Integer numOfStrings;

    public GuitarSpec(String model, Builder builder, Wood backWood, Wood topWood, Type type, Integer numOfStrings) {
        this.model = model;
        this.builder = builder;
        this.backWood = backWood;
        this.topWood = topWood;
        this.type = type;
        this.numOfStrings = numOfStrings;
    }

    public String getModel() {
        return model;
    }

    public Builder getBuilder() {
        return builder;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public Wood getTopWood() {
        return topWood;
    }

    public Type getType() {
        return type;
    }

    public Integer getNumOfStrings() {
        return numOfStrings;
    }

    public boolean match(GuitarSpec searchGuitar) {
        if (!searchGuitar.getBuilder().equals(getBuilder()))
            return false;

        if (!searchGuitar.getModel().equals(getModel()))
            return false;

        if (!searchGuitar.getType().equals(getType()))
            return false;

        if (!searchGuitar.getBackWood().equals(getBackWood()))
            return false;

        if (!searchGuitar.getTopWood().equals(getTopWood()))
            return false;

        if (!searchGuitar.getNumOfStrings().equals(getNumOfStrings()))
            return false;

        return true;
    }
}