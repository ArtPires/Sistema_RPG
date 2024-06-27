package br.edu.up.sistema_rpg.model.dados;

import br.edu.up.sistema_rpg.model.Dado;
import java.util.ArrayList;

public class D12 extends Dado {
    private static final Integer LADOS = 12;

    public D12() {}

    public Integer jogarDado(){
        return super.jogarDado(LADOS);
    }

    public ArrayList<Integer> jogarDados(Integer quantidade){
        return super.jogarDados(quantidade, LADOS);
    }

}
