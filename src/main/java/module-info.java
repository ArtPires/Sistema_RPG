module br.edu.up.sistema_rpg {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.logging.log4j;


    opens br.edu.up.sistema_rpg to javafx.fxml;
    exports br.edu.up.sistema_rpg;
    exports br.edu.up.sistema_rpg.ui;
    opens br.edu.up.sistema_rpg.ui to javafx.fxml;
}