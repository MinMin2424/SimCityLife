/*
 * Created by minmin_tranova on 04.02.2025
 */

package cz.cvut.fel.funnyproject.simcitylife.model.buildingType;

import cz.cvut.fel.funnyproject.simcitylife.enums.BuildingType;
import cz.cvut.fel.funnyproject.simcitylife.enums.Category;
import cz.cvut.fel.funnyproject.simcitylife.enums.ProductCatalogue;
import cz.cvut.fel.funnyproject.simcitylife.exceptions.InvalidTypeFurnitureException;
import cz.cvut.fel.funnyproject.simcitylife.model.Building;
import cz.cvut.fel.funnyproject.simcitylife.model.Product;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class House extends Building {
    private final BuildingType buildingType;
    private final List<Product> furniture;

    public House() {
        this.buildingType = BuildingType.HOUSE;
        this.furniture = new ArrayList<>();
    }

    public void addFurniture(Product product) {
        if (product.getProductType().getCategory() != Category.FURNITURE) {
            throw new InvalidTypeFurnitureException("Invalid furniture type");
        }
        furniture.add(product);
    }

    public void removeFurniture(Product product) {
        furniture.remove(product);
    }

    public Product getFurnitureByType(ProductCatalogue productType) {
        for (Product product : furniture) {
            if (product.getProductType() == productType) {
                return product;
            }
        }
        return null;
    }

}
