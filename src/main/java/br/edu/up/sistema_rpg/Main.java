package br.edu.up.sistema_rpg;

import br.edu.up.sistema_rpg.model.dados.D4;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("rpg-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Criador de Fichas");
        stage.setScene(scene);
        stage.show();
    }

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        D4 d4 = new D4();

        for (int i = 0; i < 10; i++) {
            System.out.println(d4.jogarDado());
        }

        ArrayList<Integer> array = new ArrayList<>(d4.jogarDados(5));

        for (Integer num : array){
            System.out.println("Valor no array: " + num);
        }

        launch();
    }
}