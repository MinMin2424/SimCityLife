package cz.cvut.fel.funnyproject.simcitylife;

import cz.cvut.fel.funnyproject.simcitylife.enums.BuildingType;
import cz.cvut.fel.funnyproject.simcitylife.enums.JobType;
import cz.cvut.fel.funnyproject.simcitylife.enums.ProductCatalogue;
import cz.cvut.fel.funnyproject.simcitylife.model.Building;
import cz.cvut.fel.funnyproject.simcitylife.model.Citizen;
import cz.cvut.fel.funnyproject.simcitylife.model.City;
import cz.cvut.fel.funnyproject.simcitylife.model.buildingType.House;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
//        launch();

        City city = new City();

        House Teacher_Mary_House = new House(); city.addBuilding(Teacher_Mary_House);
        House Student_John_House = new House(); city.addBuilding(Student_John_House);

        Citizen Teacher_Mary = new Citizen("Mary", 32, 1000, JobType.TEACHER, Teacher_Mary_House);
        Citizen Student_John = new Citizen("John", 16, 1000, JobType.STUDENT, Student_John_House);

        city.addCitizen(Teacher_Mary);
        city.addCitizen(Student_John);

        Teacher_Mary.buyProduct(ProductCatalogue.CHEESE, 2);
        Student_John.buyProduct(ProductCatalogue.MOTORCYCLE, 1);

        System.out.println(Teacher_Mary.getShoppingBag());
        System.out.println(Student_John.getShoppingBag());

//        for (int i = 0; i < 3; i++) {
//            city.simulateDay();
//        }
    }
}