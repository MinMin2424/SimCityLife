module cz.cvut.fel.funnyproject.simcitylife {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens cz.cvut.fel.funnyproject.simcitylife to javafx.fxml;
    exports cz.cvut.fel.funnyproject.simcitylife;
}