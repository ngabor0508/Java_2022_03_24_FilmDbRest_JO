module hu.nagy_gabor.filmdb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens hu.nagy_gabor.filmdb to javafx.fxml;
    exports hu.nagy_gabor.filmdb;
}