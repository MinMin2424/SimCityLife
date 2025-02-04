/*
 * Created by minmin_tranova on 04.02.2025
 */

package cz.cvut.fel.funnyProject.simCityLife.model;

import cz.cvut.fel.funnyproject.simcitylife.enums.ProductCatalogue;
import cz.cvut.fel.funnyproject.simcitylife.model.Product;
import cz.cvut.fel.funnyproject.simcitylife.model.ShoppingBag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ShoppingBagTest {

    private ShoppingBag shoppingBag;

    @BeforeEach
    public void setUp() {
        shoppingBag = new ShoppingBag();
    }

    @Test
    public void testAddProduct_Success() {
        Product first_aid_kit = new Product(ProductCatalogue.FIRST_AID_KIT, 1);
        shoppingBag.addProduct(first_aid_kit);
        assertEquals(1, shoppingBag.getProducts().size());
        assertEquals(first_aid_kit, shoppingBag.getProducts().getFirst());
        assertNotNull(shoppingBag.getProductByType(ProductCatalogue.FIRST_AID_KIT));
    }

    @Test
    public void testAddProduct_AddAlreadyExistProduct() {
        Product first_aid_kit = new Product(ProductCatalogue.FIRST_AID_KIT, 1);
        shoppingBag.addProduct(first_aid_kit);
        Product newProduct = new Product(ProductCatalogue.FIRST_AID_KIT, 3);
        shoppingBag.addProduct(newProduct);
        assertEquals(1, shoppingBag.getProducts().size());
        assertEquals(4, shoppingBag.getProductByType(ProductCatalogue.FIRST_AID_KIT).getQuantity());
    }

    @Test
    public void testAddProduct_AddNull() {
        shoppingBag.addProduct(null);
        assertEquals(0, shoppingBag.getProducts().size());
    }

    @Test
    public void testRemoveProduct_Success() {
        Product first_aid_kit = new Product(ProductCatalogue.FIRST_AID_KIT, 5);
        shoppingBag.addProduct(first_aid_kit);
        shoppingBag.removeProduct(first_aid_kit, 2);
        assertEquals(3, shoppingBag.getProductByType(ProductCatalogue.FIRST_AID_KIT).getQuantity());
    }

    @Test
    public void testRemoveProduct_RemoveAllProducts() {
        Product first_aid_kit = new Product(ProductCatalogue.FIRST_AID_KIT, 5);
        shoppingBag.addProduct(first_aid_kit);
        shoppingBag.removeProduct(first_aid_kit, 5);
        assertEquals(0, shoppingBag.getProducts().size());
    }

    @Test
    public void testRemoveProduct_NotEnoughProducts() {
        Product first_aid_kit = new Product(ProductCatalogue.FIRST_AID_KIT, 5);
        shoppingBag.addProduct(first_aid_kit);
        shoppingBag.removeProduct(first_aid_kit, 6);
        assertEquals(1, shoppingBag.getProducts().size());
    }

    @Test
    public void testGetProductByType() {
        Product first_aid_kit = new Product(ProductCatalogue.FIRST_AID_KIT, 5);
        shoppingBag.addProduct(first_aid_kit);
        assertEquals(first_aid_kit, shoppingBag.getProductByType(ProductCatalogue.FIRST_AID_KIT));
    }

}
