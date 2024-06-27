package br.edu.up.sistema_rpg.controller;

import br.edu.up.sistema_rpg.model.classes.Bardo;
import br.edu.up.sistema_rpg.model.classes.Guerreiro;
import br.edu.up.sistema_rpg.model.racas.Anao;
import br.edu.up.sistema_rpg.model.racas.Elfo;
import br.edu.up.sistema_rpg.model.racas.Humano;
import br.edu.up.sistema_rpg.model.utils.Modificadores;
import br.edu.up.sistema_rpg.model.utils.arquivos.Habilidades;

import java.lang.annotation.ElementType;
import java.util.ArrayList;

public class SistemaController {
    private final Anao anao = new Anao();
    private final Elfo elfo = new Elfo();
    private final Humano humano = new Humano();

    public SistemaController(){ }

    public Integer calcPericiasTreinadas(String classe, String valorInteligencia) throws Exception{
        return switch (classe) {
            case "Bardo" -> Bardo.calcularPericiasTreinadas(Integer.valueOf(valorInteligencia));
            case "Guerreiro" -> Guerreiro.calcularPericiasTreinadas(Integer.valueOf(valorInteligencia));
            default -> throw new Exception("A classe selecionada não é válida");
        };
    }

    public ArrayList<Habilidades> alterarHabilidades(String raca) throws Exception{
        return switch (raca) {
          case "Anão" -> anao.ajusteDeHabilidades();
          case "Elfo" -> elfo.ajusteDeHabilidades();
          case "Humano" -> humano.ajusteDeHabilidades();
          default -> throw new Exception("A raça selecionada não é válida");
        };
    }

    public Integer calcularPV(String classe, String valorConstituicao) {
        return switch (classe) {
            case "Bardo" -> Bardo.calcularPV(Integer.valueOf(valorConstituicao));
            case "Guerreiro" -> Guerreiro.calcularPV(Integer.valueOf(valorConstituicao));
            default -> 10;
        };
    }

    public Integer calcularCA(String valorDestreza) {
        return Modificadores.calcModificador(valorDestreza) + 10;
    }

    public Integer calcularCorpo(String classe, String valorForca) {
        return switch (classe) {
            case "Bardo" -> Modificadores.calcModificador(valorForca);
            case "Guerreiro" -> Modificadores.calcModificador(valorForca) + 1;
            default -> 10;
        };
    }

    public Integer calcularDistancia(String classe, String valorDestreza) {
        return switch (classe) {
            case "Bardo" -> Modificadores.calcModificador(valorDestreza);
            case "Guerreiro" -> Modificadores.calcModificador(valorDestreza) + 1;
            default -> 10;
        };
    }
}
