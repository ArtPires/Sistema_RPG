package br.edu.up.sistema_rpg.ui;

import br.edu.up.sistema_rpg.controller.SistemaController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerRPG implements Initializable {

    private SistemaController conn = new SistemaController();

    @FXML
    private Button btEditar;

    @FXML
    private Button btSalvar;

    @FXML
    private CheckBox cbAcrobacia;

    @FXML
    private CheckBox cbAdestrarAnimais;

    @FXML
    private CheckBox cbAtletismo;

    @FXML
    private CheckBox cbAtuacao;

    @FXML
    private CheckBox cbCavalgar;

    @FXML
    private CheckBox cbConhecimento;

    @FXML
    private CheckBox cbCura;

    @FXML
    private CheckBox cbDiplomacia;

    @FXML
    private CheckBox cbEnganacao;

    @FXML
    private CheckBox cbFurtividade;

    @FXML
    private CheckBox cbIdentificarMagia;

    @FXML
    private CheckBox cbIniciativa;

    @FXML
    private CheckBox cbIntuicao;

    @FXML
    private CheckBox cbLadinagem;

    @FXML
    private CheckBox cbObterInformacao;

    @FXML
    private CheckBox cbOficio;

    @FXML
    private CheckBox cbPercepcao;

    @FXML
    private CheckBox cbSobrevivencia;

    @FXML
    private CheckBox cbintimidacao;

    @FXML
    private ChoiceBox<String> chbClasse;

    @FXML
    private ChoiceBox<String> chbRaca;

    @FXML
    private TextField txfCarisma;

    @FXML
    private TextField txfConstituicao;

    @FXML
    private TextField txfDestreza;

    @FXML
    private TextField txfForca;

    @FXML
    private TextField txfInteligencia;

    @FXML
    private TextField txfNome;

    @FXML
    private TextField txfSabedoria;

    @FXML
    private VBox vbPericias;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initChoiceBox();

        vbPericias.setDisable(true);

        btSalvar.setOnAction(e -> {
            printarInfo();
        });

        chbClasse.setOnAction(e -> {
            Alert dialog = new Alert(Alert.AlertType.INFORMATION);
            dialog.setTitle("Info");
            dialog.setHeaderText("Numero de perícias treinadas: " + getPericiasTreinadas());
            dialog.showAndWait();
            vbPericias.setDisable(false);
        });

    }

    private String getPericiasTreinadas() {
        String classe = chbClasse.getValue();

        return Integer.toString(conn.calcPericiasTreinadas(classe, txfInteligencia.getText()));
    }

    private void printarInfo() {
        System.out.println("Nome: " + txfNome.getText());
        System.out.println("Classe: " + chbClasse.getValue());
        System.out.println("Raça: "+ chbRaca.getValue());
        System.out.println("Força: " + txfForca.getText());
        System.out.println("Destreza: " + txfDestreza.getText());
        System.out.println("Constituicao: " + txfConstituicao.getText());
        System.out.println("Inteligencia: " + txfInteligencia.getText());
        System.out.println("Sabedoria: " + txfSabedoria.getText());
        System.out.println("Carisma: " + txfCarisma.getText());
    }

    private void initChoiceBox() {
        chbClasse.getItems().addAll("Bardo", "Guerreiro", "Ladino", "Mago", "Paladino");
        chbRaca.getItems().addAll("Anão", "Elfo", "Humano", "Goblin");
    }
}