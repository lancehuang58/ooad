package ch1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        Guitar whatErinLikes = new Guitar("", 0, FENDER, "Stratocastor",
                ELECTRIC, ALDER, ALDER);
        Guitar guitar = inventory.search(whatErinLikes);
        if (guitar != null) {
            System.out.println("Erin, you might like this " +
                    guitar.getBuilder() + " " + guitar.getModel() +  " " +
                    guitar.getType() + " guitar:\n   " +
                    guitar.getBackWood() + " back and sides,\n   " +
                    guitar.getTopWood() + " top.\nYou can have it for only $" +
                    guitar.getPrice() + "!");
        } else {
            System.out.println("Sorry, Erin, we have nothing for you.");
        }


        Assertions.assertThat(guitar).isNotNull();


    }



    private static void initializeInventory(Inventory inventory) {
        inventory.addGuitar("11277", 3999.95, COLLINGS, "CJ", ACOUSTIC,
                Wood.INDIAN_ROSEWOOD, Wood.SITKA);
        inventory.addGuitar("V95693", 1499.95, FENDER, "Stratocastor", ELECTRIC,
                ALDER, ALDER);
        inventory.addGuitar("V9512", 1549.95, FENDER, "Stratocastor", ELECTRIC,
                ALDER, ALDER);
        inventory.addGuitar("122784", 5495.95, MARTIN, "D-18", ACOUSTIC,
                MAHOGANY, ADIRONDACK);
        inventory.addGuitar("76531", 6295.95, MARTIN, "OM-28", ACOUSTIC,
                BRAZILIAN_ROSEWOOD, ADIRONDACK);
        inventory.addGuitar("70108276", 2295.95, GIBSON, "Les Paul", ELECTRIC,
                MAHOGANY, MAPLE);
        inventory.addGuitar("82765501", 1890.95, GIBSON, "SG '61 Reissue",
                ELECTRIC, MAHOGANY, MAHOGANY);
        inventory.addGuitar("77023", 6275.95, MARTIN, "D-28", ACOUSTIC,
                BRAZILIAN_ROSEWOOD, ADIRONDACK);
        inventory.addGuitar("1092", 12995.95, OLSON, "SJ", ACOUSTIC,
                INDIAN_ROSEWOOD, CEDAR);
        inventory.addGuitar("566-62", 8999.95, RYAN, "Cathedral", ACOUSTIC,
                COCOBOLO, CEDAR);
        inventory.addGuitar("6 29584", 2100.95, PRS, "Dave Navarro Signature",
                ELECTRIC, MAHOGANY, MAPLE);
    }
}