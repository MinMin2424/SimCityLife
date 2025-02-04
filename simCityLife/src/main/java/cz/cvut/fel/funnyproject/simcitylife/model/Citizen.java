/*
 * Created by minmin_tranova on 03.02.2025
 */

package cz.cvut.fel.funnyproject.simcitylife.model;

import cz.cvut.fel.funnyproject.simcitylife.enums.JobType;
import cz.cvut.fel.funnyproject.simcitylife.enums.ProductCatalogue;
import cz.cvut.fel.funnyproject.simcitylife.exceptions.HouseNotContainsFurnitureException;
import cz.cvut.fel.funnyproject.simcitylife.exceptions.InvalidQuantityException;
import cz.cvut.fel.funnyproject.simcitylife.exceptions.NotEnoughMoneyException;
import cz.cvut.fel.funnyproject.simcitylife.exceptions.NullProductException;
import cz.cvut.fel.funnyproject.simcitylife.exceptions.ShoppingBagNotContainsProductException;
import cz.cvut.fel.funnyproject.simcitylife.model.buildingType.House;
import lombok.Getter;

@Getter
public class Citizen {

    private final String name;
    private int age;
    private double money;
    private JobType job;
    private final ShoppingBag shoppingBag;
    private final House house;

    public Citizen(String name, int age, double money, JobType job, House house) {
        this.name = name;
        this.age = age;
        this.money = money;
        this.job = job;
        this.shoppingBag = new ShoppingBag();
        this.house = house;
    }

    public void liveOneDay() {
        System.out.println(name + " prožívá další den.");
        if (job.getSalary() != 0) {
            money += job.getSalary();
        }
    }

    public void buyProduct(ProductCatalogue product, int quantity) {
        try {
            checkQuantity(quantity);
            checkWallet(product);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return;
        }
        Product purchasedProduct = new Product(product, quantity);
        shoppingBag.addProduct(purchasedProduct);
        money -= purchasedProduct.getTotalPrice();
        System.out.println("Successful purchase " + product.name());
    }

    public void addProductToHouse(Product product) {
        try {
            checkProduct(product);
            checkShoppingBagContainsProduct(product);
            house.addFurniture(product);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return;
        }
        shoppingBag.removeProduct(product, product.getQuantity());
    }

    public void removeProductFromHouse(Product product) {
        try {
            checkHouseContainsFurniture(product);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return;
        }
        house.removeFurniture(product);
    }

    private void checkQuantity(int quantity) {
        if (quantity <= 0) {
            throw new InvalidQuantityException("Quantity must be greater than zero");
        }
    }

    private void checkWallet(ProductCatalogue product) {
        if (product.getCost() > money) {
            throw new NotEnoughMoneyException("Not enough money to buy the product");
        }
    }

    private void checkProduct(Product product) {
        if (product == null) {
            throw new NullProductException("Product cannot be null");
        }
    }

    private void checkShoppingBagContainsProduct(Product product) {
        boolean found = false;
        for (Product p : shoppingBag.getProducts()) {
            if (p.equals(product)) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw new ShoppingBagNotContainsProductException("Shopping bag does not contain product.");
        }
    }

    private void checkHouseContainsFurniture(Product product) {
        boolean found = false;
        for (Product p : house.getFurniture()) {
            if (p.equals(product)) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw new HouseNotContainsFurnitureException("This house does not contain furniture.");
        }
    }

}
