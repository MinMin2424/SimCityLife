/*
 * Created by minmin_tranova on 04.02.2025
 */

package cz.cvut.fel.funnyproject.simcitylife.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProductCatalogue {

    // Food & Groceries
    BREAD(2, Category.FOOD),
    MILK(3, Category.FOOD),
    APPLE(1, Category.FOOD),
    MEAT(8, Category.FOOD),
    RICE(4, Category.FOOD),
    CHEESE(5, Category.FOOD),

    // Clothing
    T_SHIRT(15, Category.CLOTHING),
    JEANS(40, Category.CLOTHING),
    SNEAKERS(60, Category.CLOTHING),
    JACKET(80, Category.CLOTHING),
    HAT(10, Category.CLOTHING),

    // Electronics
    SMARTPHONE(500, Category.ELECTRONICS),
    LAPTOP(1_000, Category.ELECTRONICS),
    HEADPHONES(80, Category.ELECTRONICS),
    TV(700, Category.ELECTRONICS),
    POWER_BANK(40, Category.ELECTRONICS),

    // Home & Furniture
    BED(300, Category.FURNITURE),
    SOFA(500, Category.FURNITURE),
    CHAIR(100, Category.FURNITURE),
    DINING_TABLE(250, Category.FURNITURE),
    LAMP(50, Category.FURNITURE),

    // Health & Medicine
    PAINKILLERS(10, Category.MEDICINE),
    BANDAGES(5, Category.MEDICINE),
    THERMOMETER(20, Category.MEDICINE),
    FIRST_AID_KIT(50, Category.MEDICINE),

    // Transport
    BICYCLE(200, Category.TRANSPORT),
    MOTORCYCLE(3_000, Category.TRANSPORT),
    CAR(20_000, Category.TRANSPORT),
    FUEL(4, Category.TRANSPORT),

    // Entertainment
    VIDEO_GAME(60, Category.ENTERTAINMENT),
    BOOK(20, Category.ENTERTAINMENT),
    MOVIE_TICKET(12, Category.ENTERTAINMENT),
    GUITAR(250, Category.ENTERTAINMENT),
    MUSIC_SUBSCRIPTION(10, Category.ENTERTAINMENT);

    private final double cost;
    private final Category category;
}
