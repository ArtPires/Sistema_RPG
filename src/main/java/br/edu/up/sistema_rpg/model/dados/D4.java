package br.edu.up.sistema_rpg.model.dados;

import br.edu.up.sistema_rpg.model.Dado;
import java.util.ArrayList;

public class D4 extends Dado {
    private static final Integer LADOS = 4;

    public D4 () {}

    public Integer jogarDado(){
        return super.jogarDado(LADOS);
    }

    public ArrayList<Integer> jogarDados(Integer quantidade){
        return super.jogarDados(quantidade, LADOS);
    }

}
