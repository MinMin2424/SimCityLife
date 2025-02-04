/*
 * Created by minmin_tranova on 03.02.2025
 */

package cz.cvut.fel.funnyproject.simcitylife.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class City {
    private final List<Citizen> citizens;
    private final List<Building> buildings;
    private final Economy economy;

    public City() {
        this.citizens = new ArrayList<>();
        this.buildings = new ArrayList<>();
        this.economy = new Economy();
    }

    public void addCitizen(Citizen citizen) {
        citizens.add(citizen);
    }

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public void simulateDay() {
        System.out.println("Simulace dne začala ...");
        for (Citizen citizen : citizens) {
            citizen.liveOneDay();
        }
        economy.updateEconomy(citizens);
    }
}
