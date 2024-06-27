package br.edu.up.sistema_rpg.controller;

import br.edu.up.sistema_rpg.model.classes.Bardo;
import br.edu.up.sistema_rpg.model.classes.Guerreiro;

public class SistemaController {

    public SistemaController(){ }

    public Integer calcPericiasTreinadas(String classe, String valorInteligencia) throws Exception{
        switch (classe){
            case "Bardo":
                //Bardo.calcularPericiasTreinadas(valorInteligencia);
                break;

            case "Guerreiro":
                return Guerreiro.calcularPericiasTreinadas(Integer.valueOf(valorInteligencia));

            default:
                throw new RuntimeException("A classe selecionada não é válida");
        }
        return null;
    }
}
