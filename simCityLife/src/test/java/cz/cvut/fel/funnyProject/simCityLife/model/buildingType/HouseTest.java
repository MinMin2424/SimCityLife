/*
 * Created by minmin_tranova on 04.02.2025
 */

package cz.cvut.fel.funnyProject.simCityLife.model.buildingType;

import cz.cvut.fel.funnyproject.simcitylife.enums.ProductCatalogue;
import cz.cvut.fel.funnyproject.simcitylife.exceptions.InvalidTypeFurnitureException;
import cz.cvut.fel.funnyproject.simcitylife.model.Product;
import cz.cvut.fel.funnyproject.simcitylife.model.buildingType.House;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HouseTest {

    House house;

    @BeforeEach
    public void setUp() {
        house = new House();
    }

    @Test
    public void testAddFurniture_Success() {
        Product chair = new Product(ProductCatalogue.CHAIR, 4);
        house.addFurniture(chair);
        assertEquals(1, house.getFurniture().size());
        assertEquals(4, house.getFurnitureByType(ProductCatalogue.CHAIR).getQuantity());
    }

    @Test
    public void testAddFurniture_Fail() {
        Product laptop = new Product(ProductCatalogue.LAPTOP, 4);
        assertThrows(InvalidTypeFurnitureException.class, () -> house.addFurniture(laptop));
        assertEquals(0, house.getFurniture().size());
    }
}
