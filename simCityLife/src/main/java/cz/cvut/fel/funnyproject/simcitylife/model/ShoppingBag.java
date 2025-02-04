/*
 * Created by minmin_tranova on 04.02.2025
 */

package cz.cvut.fel.funnyproject.simcitylife.model;

import cz.cvut.fel.funnyproject.simcitylife.enums.ProductCatalogue;
import cz.cvut.fel.funnyproject.simcitylife.exceptions.NotEnoughMoneyException;
import cz.cvut.fel.funnyproject.simcitylife.exceptions.NotEnoughProductQuantityException;
import cz.cvut.fel.funnyproject.simcitylife.exceptions.NullProductException;
import cz.cvut.fel.funnyproject.simcitylife.exceptions.ShoppingBagNotContainsProductException;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ShoppingBag {

    private final List<Product> products;

    public ShoppingBag() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        try {
            checkProduct(product);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return;
        }
        boolean found = false;
        for (Product p : products) {
            if (p.getProductType().equals(product.getProductType())) {
                p.setQuantity(p.getQuantity() + product.getQuantity());
                found = true;
                break;
            }
        }
        if (!found) {
            products.add(product);
        }
    }

    public void removeProduct(Product product, int quantity) {
        try {
            checkProduct(product);
            checkProductQuantity(product, quantity);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return;
        }
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if (p.getProductType().equals(product.getProductType())) {
                if(p.getQuantity() > quantity) {
                    p.setQuantity(p.getQuantity() - quantity);
                } else {
                    products.remove(i);
                }
                break;
            }
        }
    }

    public Product getProductByType(ProductCatalogue productType) {
        for (Product product : products) {
            if (product.getProductType() == productType) {
                return product;
            }
        }
        return null;
    }

    private void checkProduct(Product product) {
        if (product == null) {
            throw new NullProductException("Product cannot be null");
        }
    }

    private void checkProductQuantity(Product product, int quantity) {
        if (product.getQuantity() < quantity) {
            throw new NotEnoughProductQuantityException("Not enough product quantity");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Product p : products) {
            sb.append(p.getProductType()).append(": ").append(p.getQuantity()).append("\n");
        }
        return sb.toString();
    }
}
