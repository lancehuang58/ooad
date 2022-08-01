package ch1;

public class Guitar {

  private final String serialNumber;
  private final GuitarSpec guitarSpec;

  private double price;

  public Guitar(String serialNumber, double price,
                Builder builder, String model, Type type,
                Wood backWood, Wood topWood, Integer numOfStrings) {
    this.serialNumber = serialNumber;
    this.price = price;
    this.guitarSpec = new GuitarSpec(model, builder, backWood, topWood, type, numOfStrings);
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public double getPrice() {
    return price;
  }
  public void setPrice(float newPrice) {
    this.price = newPrice;
  }
  public String getModel() {
    return guitarSpec.getModel();
  }

  public Builder getBuilder() {
    return guitarSpec.getBuilder();
  }

  public Wood getBackWood() {
    return guitarSpec.getBackWood();
  }

  public Wood getTopWood() {
    return guitarSpec.getTopWood();
  }

  public Type getType() {
    return guitarSpec.getType();
  }

  public Integer getNumOfStrings() {
    return this.guitarSpec.getNumOfStrings();
  }

  public GuitarSpec getGuitarSpec() {
    return guitarSpec;
  }
}
