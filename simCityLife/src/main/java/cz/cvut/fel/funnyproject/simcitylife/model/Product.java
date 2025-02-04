/*
 * Created by minmin_tranova on 04.02.2025
 */

package cz.cvut.fel.funnyproject.simcitylife.model;

import cz.cvut.fel.funnyproject.simcitylife.enums.ProductCatalogue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    private ProductCatalogue productType;
    private int quantity;

    public double getTotalPrice() {
        return quantity * productType.getCost();
    }

}
