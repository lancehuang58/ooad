package ch1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private final List<Guitar> guitars;

    public Inventory() {
        guitars = new LinkedList<>();
    }

    public void addGuitar(String serialNumber, double price,
                          Builder builder, String model,
                          Type type, Wood backWood, Wood topWood, Integer numOfStrings) {
        Guitar guitar = new Guitar(serialNumber, price, builder,
                model, type, backWood, topWood, numOfStrings);
        guitars.add(guitar);
    }

    public Guitar getGuitar(String serialNumber) {
        for (Guitar guitar : guitars) {
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }

    public List<Guitar> search(GuitarSpec searchGuitar) {

        List<Guitar> matchGuitars = new LinkedList<>();
        for (Guitar guitar : guitars) {
            if (!guitar.getGuitarSpec().match(searchGuitar)) {
                continue;
            }
            matchGuitars.add(guitar);
        }
        System.out.println(matchGuitars);

        return matchGuitars;
    }
}
