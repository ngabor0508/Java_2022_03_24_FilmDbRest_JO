module hu.nagy_gabor.filmdb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.google.gson;


    opens hu.nagy_gabor.filmdb to javafx.fxml, com.google.gson;
    exports hu.nagy_gabor.filmdb;
    exports hu.nagy_gabor.filmdb.controllers;
    opens hu.nagy_gabor.filmdb.controllers to javafx.fxml;
}