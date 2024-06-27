package br.edu.up.sistema_rpg;

import br.edu.up.sistema_rpg.model.dados.D4;
import br.edu.up.sistema_rpg.model.utils.FileManager;
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


        logger.info("Iniciando aplicação...");
        logger.debug("Iniciando aplicação...");
        logger.error("Iniciando aplicação...");

        D4 d4 = new D4();

        for (int i = 0; i < 10; i++) {
            System.out.println(d4.jogarDado());
        }

        ArrayList<Integer> array = new ArrayList<>(d4.jogarDados(5));

        for (Integer num : array){
            System.out.println("Valor no array: " + num);
        }

        String filePath = "arquivo.txt";
        try {
            FileManager.adicionarConteudo(filePath, "Nova linha de conteúdo no arquivo.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileManager.editarConteudo(filePath, "Nova linha de conteúdo no arquivo.", "Conteúdo novo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Remove conteúdo específico do arquivo
        try {
            FileManager.removerConteudo(filePath, "Nova linha de conteúdo no arquivo.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Lê o conteúdo do arquivo
        String fileContent = null;
        try {
            fileContent = FileManager.lerConteudo("src/main/java/br/edu/up/sistema_rpg/model/utils/arquivos/" + filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Conteúdo do arquivo:\n" + fileContent);

        launch();
    }
}