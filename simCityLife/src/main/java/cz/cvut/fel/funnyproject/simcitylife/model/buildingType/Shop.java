/*
 * Created by minmin_tranova on 04.02.2025
 */

package cz.cvut.fel.funnyproject.simcitylife.model.buildingType;

import cz.cvut.fel.funnyproject.simcitylife.enums.ProductCatalogue;
import cz.cvut.fel.funnyproject.simcitylife.model.Building;
import lombok.Getter;

import java.util.List;

import static cz.cvut.fel.funnyproject.simcitylife.enums.ProductCatalogue.*;

@Getter
public class Shop extends Building {
    private final List<ProductCatalogue> productCatalogues = List.of(
            BREAD, MILK, APPLE, MEAT, RICE, CHEESE,
            T_SHIRT, JEANS, SNEAKERS, JACKET, HAT,
            SMARTPHONE, LAPTOP, HEADPHONES, TV, POWER_BANK,
            BED, SOFA, CHAIR, DINING_TABLE, LAMP,
            PAINKILLERS, BANDAGES, THERMOMETER, FIRST_AID_KIT,
            BICYCLE, MOTORCYCLE, CAR, FUEL,
            VIDEO_GAME, BOOK, MOVIE_TICKET, GUITAR, MUSIC_SUBSCRIPTION
    );
}
