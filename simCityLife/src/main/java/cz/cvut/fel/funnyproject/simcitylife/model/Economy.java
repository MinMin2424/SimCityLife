/*
 * Created by minmin_tranova on 03.02.2025
 */

package cz.cvut.fel.funnyproject.simcitylife.model;

import java.util.List;

public class Economy {
    public void updateEconomy(List<Citizen> citizens) {
        System.out.println("Aktualizace ekonomiky ...");
        double totalMoney = citizens.stream()
                .mapToDouble(Citizen::getMoney)
                .sum();
        System.out.println("Celkové bohatství města: " + totalMoney + "$.");
    }
}
