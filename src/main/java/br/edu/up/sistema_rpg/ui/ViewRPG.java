package br.edu.up.sistema_rpg.ui;

import br.edu.up.sistema_rpg.controller.SistemaController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ViewRPG implements Initializable {

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
            if (!Objects.equals(txfInteligencia.getText(), "")) {
                Alert dialog = new Alert(Alert.AlertType.INFORMATION);
                dialog.setTitle("Info");
                dialog.setHeaderText("Numero de perícias treinadas: " + getPericiasTreinadas());
                dialog.showAndWait();
                liebrarPericias();
            } else {
                Alert dialog = new Alert(Alert.AlertType.ERROR);
                dialog.setTitle("ERRO");
                dialog.setHeaderText("Preencha todos os campos de Habilidades antes de selecionar uma Classe!");
                dialog.showAndWait();
                chbClasse.setValue("");
            }
        });
    }

    private void initChoiceBox() {
        chbClasse.getItems().addAll("Bardo", "Guerreiro");
        chbRaca.getItems().addAll("Anão", "Elfo", "Humano");
    }

    private String getPericiasTreinadas() {
        String classe = chbClasse.getValue();
        try {
            return Integer.toString(conn.calcPericiasTreinadas(classe, txfInteligencia.getText()));
        } catch (Exception e){
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("ERRO");
            dialog.setHeaderText(e.fillInStackTrace().toString());
            dialog.showAndWait();
        }
        return null;
    }

    private void liebrarPericias() {
        vbPericias.setDisable(false);
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
}
