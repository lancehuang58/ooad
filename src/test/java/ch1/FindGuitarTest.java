package ch1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ch1.Builder.*;
import static ch1.Type.*;
import static ch1.Wood.*;


class FindGuitarTest {
    Inventory inventory;

    @BeforeEach
    public void init() {
        inventory = new Inventory();
        initializeInventory(inventory);
    }

    @Test
    public void search_by_example() {
        GuitarSpec whatErinLikes = new GuitarSpec("Stratocastor", FENDER,
                ALDER, ALDER, ELECTRIC, 4);
        List<Guitar> guitars = inventory.search(whatErinLikes);
        if (guitars != null && !guitars.isEmpty()) {
            for (Guitar guitar : guitars) {
                System.out.println("Hi, you might like this " +
                        guitar.getBuilder() + " " + guitar.getModel() + " " +
                        guitar.getType() + " guitar:\n   " +
                        guitar.getBackWood() + " back and sides,\n   " +
                        guitar.getTopWood() + " top.\nYou can have it for only $" +
                        guitar.getPrice() + "!");
            }
        } else {
            System.out.println("Sorry, Erin, we have nothing for you.");
        }


        Assertions.assertThat(guitars).isNotEmpty().hasSize(2);


    }


    private static void initializeInventory(Inventory inventory) {
        inventory.addGuitar("11277", 3999.95, COLLINGS, "CJ", ACOUSTIC,
                Wood.INDIAN_ROSEWOOD, Wood.SITKA, 3);
        inventory.addGuitar("V95693", 1499.95, FENDER, "Stratocastor", ELECTRIC,
                ALDER, ALDER, 4);
        inventory.addGuitar("V9512", 1549.95, FENDER, "Stratocastor", ELECTRIC,
                ALDER, ALDER, 4);
        inventory.addGuitar("122784", 5495.95, MARTIN, "D-18", ACOUSTIC,
                MAHOGANY, ADIRONDACK, 5);
        inventory.addGuitar("76531", 6295.95, MARTIN, "OM-28", ACOUSTIC,
                BRAZILIAN_ROSEWOOD, ADIRONDACK, 5);
        inventory.addGuitar("70108276", 2295.95, GIBSON, "Les Paul", ELECTRIC,
                MAHOGANY, MAPLE, 4);
        inventory.addGuitar("82765501", 1890.95, GIBSON, "SG '61 Reissue",
                ELECTRIC, MAHOGANY, MAHOGANY, 4);
        inventory.addGuitar("77023", 6275.95, MARTIN, "D-28", ACOUSTIC,
                BRAZILIAN_ROSEWOOD, ADIRONDACK, 4);
        inventory.addGuitar("1092", 12995.95, OLSON, "SJ", ACOUSTIC,
                INDIAN_ROSEWOOD, CEDAR, 5);
        inventory.addGuitar("566-62", 8999.95, RYAN, "Cathedral", ACOUSTIC,
                COCOBOLO, CEDAR, 5);
        inventory.addGuitar("6 29584", 2100.95, PRS, "Dave Navarro Signature",
                ELECTRIC, MAHOGANY, MAPLE, 5);
    }
}