/*
 * Created by minmin_tranova on 04.02.2025
 */

package cz.cvut.fel.funnyProject.simCityLife.model;

import cz.cvut.fel.funnyproject.simcitylife.enums.JobType;
import cz.cvut.fel.funnyproject.simcitylife.enums.ProductCatalogue;
import cz.cvut.fel.funnyproject.simcitylife.model.Citizen;
import cz.cvut.fel.funnyproject.simcitylife.model.buildingType.House;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CitizenTest {

    private Citizen citizen;
    private House house;

    @BeforeEach
    public void setUp() {
        house = new House();
        citizen = new Citizen("Mina", 21, 100, JobType.STUDENT, house);
    }

    @Test
    public void testBuyProduct_AddNewProduct_Success() {
        citizen.buyProduct(ProductCatalogue.CHEESE, 4);
        assertEquals(80, citizen.getMoney());
        assertEquals(1, citizen.getShoppingBag().getProducts().size());
        assertEquals(4, citizen.getShoppingBag().getProductByType(ProductCatalogue.CHEESE).getQuantity());
    }

    @Test
    public void testBuyProduct_AddAlreadyExistProduct_Success() {
        citizen.buyProduct(ProductCatalogue.CHEESE, 4);
        citizen.buyProduct(ProductCatalogue.CHEESE, 5);
        double totalCost = 20 + 25;
        assertEquals(100-45, citizen.getMoney());
        assertEquals(1, citizen.getShoppingBag().getProducts().size());
        assertEquals(9, citizen.getShoppingBag().getProductByType(ProductCatalogue.CHEESE).getQuantity());
    }

    @Test
    public void testBuyProduct_AddNewProduct_NotEnoughMoney() {
        citizen.buyProduct(ProductCatalogue.MOTORCYCLE, 4);
        assertEquals(100, citizen.getMoney());
        assertEquals(0, citizen.getShoppingBag().getProducts().size());
    }

    @Test
    public void testAddProductToHouse_Success() {
        citizen.buyProduct(ProductCatalogue.CHAIR, 4);
        citizen.addProductToHouse(citizen.getShoppingBag().getProductByType(ProductCatalogue.CHAIR));
        assertEquals(ProductCatalogue.CHAIR, citizen.getHouse().getFurniture().getFirst().getProductType());
        assertEquals(4, citizen.getHouse().getFurniture().getFirst().getQuantity());
        assertEquals(0, citizen.getShoppingBag().getProducts().size());
    }

    @Test
    public void testAddProductToHouse_InvalidTypeFurniture() {
        citizen.buyProduct(ProductCatalogue.BREAD, 5);
        citizen.addProductToHouse(citizen.getShoppingBag().getProductByType(ProductCatalogue.BREAD));
        assertEquals(0, citizen.getHouse().getFurniture().size());
        assertEquals(1, citizen.getShoppingBag().getProducts().size());
    }

    @Test
    public void testAddProductToHouse_ShoppingBagDoesNotContainProduct() {
        citizen.addProductToHouse(citizen.getShoppingBag().getProductByType(ProductCatalogue.CHAIR));
        assertEquals(0, citizen.getShoppingBag().getProducts().size());
        assertEquals(0, citizen.getHouse().getFurniture().size());
    }
}
