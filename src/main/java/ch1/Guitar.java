package ch1;

public class Guitar {

  private final String serialNumber;
  private final String model;
  private final Builder builder;
  private final Wood backWood;
  private final Wood topWood;
  private final Type type;

  private double price;

  public Guitar(String serialNumber, double price,
                Builder builder, String model, Type type,
                Wood backWood, Wood topWood) {
    this.serialNumber = serialNumber;
    this.price = price;
    this.builder = builder;
    this.model = model;
    this.type = type;
    this.backWood = backWood;
    this.topWood = topWood;
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
}
