package br.edu.up.sistema_rpg.controller;

import br.edu.up.sistema_rpg.model.classes.Bardo;
import br.edu.up.sistema_rpg.model.classes.Guerreiro;

public class SistemaController {

    public SistemaController(){ }

    public Integer calcPericiasTreinadas(String classe, String valorInteligencia) throws Exception{
        return switch (classe) {
            case "Bardo" -> Bardo.calcularPericiasTreinadas(Integer.valueOf(valorInteligencia));
            case "Guerreiro" -> Guerreiro.calcularPericiasTreinadas(Integer.valueOf(valorInteligencia));
            default -> throw new Exception("A classe selecionada não é válida");
        };
    }
}
