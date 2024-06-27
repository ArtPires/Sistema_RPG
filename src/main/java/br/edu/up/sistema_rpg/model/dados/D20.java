package br.edu.up.sistema_rpg.model.dados;

import br.edu.up.sistema_rpg.model.Dado;
import java.util.ArrayList;

public class D20 extends Dado {
    private static final Integer LADOS = 20;

    public D20 () {}

    public Integer jogarDado(){
        return super.jogarDado(LADOS);
    }

    public ArrayList<Integer> jogarDados(Integer quantidade){
        return super.jogarDados(quantidade, LADOS);
    }

}
