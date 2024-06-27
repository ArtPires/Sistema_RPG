package br.edu.up.sistema_rpg.model.dados;

import br.edu.up.sistema_rpg.model.Dado;
import java.util.ArrayList;

public class D10 extends Dado {
    private static final Integer LADOS = 10;

    public D10() {}

    public Integer jogarDado(){
        return super.jogarDado(LADOS);
    }

    public ArrayList<Integer> jogarDados(Integer quantidade){
        return super.jogarDados(quantidade, LADOS);
    }

}
