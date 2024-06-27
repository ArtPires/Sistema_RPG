package br.edu.up.sistema_rpg.model;

import java.util.ArrayList;
import java.util.Random;

public abstract class Dado {

    Random rand = new Random();
    ArrayList<Integer> arrayResultados = new ArrayList<>();

    public Integer jogarDado(Integer lados){
        return rand.nextInt(lados) + 1;
    }

    public ArrayList<Integer> jogarDados(Integer quantidade, Integer lados){
        for (int i = 0; i < quantidade; i++) {
            arrayResultados.add(jogarDado(lados));
        }
        return arrayResultados;
    }
}
