package br.edu.up.sistema_rpg.ui;

import br.edu.up.sistema_rpg.controller.SistemaController;
import br.edu.up.sistema_rpg.model.utils.FileManager;
import br.edu.up.sistema_rpg.model.utils.arquivos.Habilidades;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class ViewRPG implements Initializable {

    private final SistemaController conn = new SistemaController();

    @FXML private Button btEditar;

    @FXML private Button btSalvar;

    @FXML private ChoiceBox<String> chbClasse;

    @FXML private ChoiceBox<String> chbRaca;

    @FXML private TextField txfCarisma;

    @FXML private TextField txfConstituicao;

    @FXML private TextField txfDestreza;

    @FXML private TextField txfForca;

    @FXML private TextField txfInteligencia;

    @FXML private TextField txfNome;

    @FXML private TextField txfSabedoria;

    @FXML private VBox vbPericias;

    @FXML private TextField txfPontosDeVida;
    @FXML private TextField txfClasseDeArmadura;

    @FXML private TextField txfAtaqueCorpo;
    @FXML private TextField txfAtaqueDistancia;

    @FXML private HBox hbCentral;
    @FXML private HBox hbTopo;

    @FXML private Tab tabDados;
    @FXML private TextField txfQuantidade;
    @FXML private ChoiceBox<String> chbDado;
    @FXML private Button btDado;
    @FXML private Label labelResult;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initChoiceBox();

        vbPericias.setDisable(true);

        btSalvar.setOnAction(e -> {
            salvarPersonagem();
            preencerFicha();
            privarTudo();
        });

        btDado.setOnAction(e -> {
            liberarTudo();
        });

        btEditar.setOnAction(e -> {
            liberarTudo();
        });

        chbClasse.setOnAction(e -> {
            if (chbRaca.getSelectionModel().getSelectedItem() != null) {
                liebrarPericias();
            }
        });

        chbRaca.setOnAction(e -> {
            alterarHabilidades();
            if (chbClasse.getSelectionModel().getSelectedItem() != null) {
                liebrarPericias();
            }
        });
    }

    private void liberarTudo() {
        hbTopo.setDisable(false);
        hbCentral.setDisable(false);
    }

    private void privarTudo() {
        hbTopo.setDisable(true);
        hbCentral.setDisable(true);
    }

    private void preencerFicha() {
        adicionarPontosDeVida();
        adicionarClasseDeArmadura();
        adicionarCorpoACorpo();
        adicionarDistancia();
    }

    private void salvarPersonagem() {
        String filePath = "Personagens.txt";
        try {
            FileManager.adicionarConteudo(filePath, txfNome.getText());
        } catch (IOException e) {
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("ERRO");
            dialog.setHeaderText(e.fillInStackTrace().toString());
            dialog.showAndWait();
        }
    }

    private void alterarHabilidades() {
        try {
            for (Habilidades habilidade : conn.alterarHabilidades(chbRaca.getValue())){
                switch (habilidade.getNome()) {
                    case "Força":
                        txfForca.setText(somarHabilidades(txfForca.getText(), habilidade.getValor()));
                        break;
                    case "Destreza":
                        txfDestreza.setText(somarHabilidades(txfDestreza.getText(), habilidade.getValor()));
                        break;
                    case "Constituição":
                        txfConstituicao.setText(somarHabilidades(txfConstituicao.getText(), habilidade.getValor()));
                        break;
                    case "Inteligencia":
                        txfInteligencia.setText(somarHabilidades(txfInteligencia.getText(), habilidade.getValor()));
                        break;
                    case "Sabedoria":
                        txfSabedoria.setText(somarHabilidades(txfSabedoria.getText(), habilidade.getValor()));
                        break;
                    case "Carisma":
                        txfCarisma.setText(somarHabilidades(txfCarisma.getText(), habilidade.getValor()));
                        break;
                    default:
                }
            }
        } catch (Exception e){
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("ERRO");
            dialog.setHeaderText(e.fillInStackTrace().toString());
            dialog.showAndWait();
        }
    }

    private String somarHabilidades(String habilidade, Integer valor) {
        return String.valueOf(Integer.parseInt(habilidade) + valor);
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

    private Boolean verificaNull(TextField txfDefault) {
        return Objects.equals(txfDefault.getText(), "");
    }

    private void liebrarPericias() {
        if (!verificaNull(txfForca) && !verificaNull(txfDestreza) && !verificaNull(txfConstituicao) &&
                !verificaNull(txfInteligencia) && !verificaNull(txfSabedoria) && !verificaNull(txfCarisma))
        {
            Alert dialog = new Alert(Alert.AlertType.INFORMATION);
            dialog.setTitle("Info");
            dialog.setHeaderText("Numero de perícias treinadas: " + getPericiasTreinadas());
            dialog.showAndWait();
            vbPericias.setDisable(false);
        } else {
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("ERRO");
            dialog.setHeaderText("Preencha todos os campos de Habilidades antes de selecionar uma Classe e uma Raça!");
            dialog.showAndWait();
            chbClasse.setValue(null);
            chbRaca.setValue(null);
            vbPericias.setDisable(true);
        }
    }

    private void adicionarPontosDeVida() {
        txfPontosDeVida.setText(String.valueOf(conn.calcularPV(chbClasse.getValue(), txfConstituicao.getText())));
    }

    private void adicionarClasseDeArmadura(){
        txfClasseDeArmadura.setText(String.valueOf(conn.calcularCA(txfDestreza.getText())));
    }

    private void adicionarCorpoACorpo(){
        txfAtaqueCorpo.setText(String.valueOf(conn.calcularCorpo(chbClasse.getValue(), txfForca.getText())));
    }

    private void adicionarDistancia(){
        txfAtaqueDistancia.setText(String.valueOf(conn.calcularCorpo(chbClasse.getValue(), txfDestreza.getText())));
    }
}
