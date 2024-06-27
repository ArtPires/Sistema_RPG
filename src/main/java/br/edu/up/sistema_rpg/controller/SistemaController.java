package br.edu.up.sistema_rpg.controller;

import br.edu.up.sistema_rpg.model.classes.Bardo;

public class SistemaController {

    public SistemaController(){ }

    public Integer calcPericiasTreinadas(String classe, String valorInteligencia) throws RuntimeException{
        switch (classe){
            case "Bardo":
                //Bardo.calcularPericiasTreinadas(valorInteligencia);
                break;

            default:
                throw new RuntimeException("A classe selecionada não é válida");
        }
        return null;
    }
}
