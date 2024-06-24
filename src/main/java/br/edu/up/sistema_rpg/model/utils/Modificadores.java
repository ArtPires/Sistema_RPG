package br.edu.up.sistema_rpg.model.utils;

public class Modificadores {

    public Modificadores() { }

    public static Integer calcModificador(String valorHabilidade){
        return consultaTabelaModificadores(Integer.parseInt(valorHabilidade));
    }

    public static Integer calcModificador(Integer valorHabilidade){
        return consultaTabelaModificadores(valorHabilidade);
    }

    private static Integer consultaTabelaModificadores(Integer valorHabilidade){
        int modHabilidade = -10;

        if (valorHabilidade == 1){ modHabilidade = -5; }

        if (valorHabilidade == 2 || valorHabilidade == 3){ modHabilidade = -4; }

        if (valorHabilidade == 4 || valorHabilidade == 5){ modHabilidade = -3; }

        if (valorHabilidade == 6 || valorHabilidade == 7){ modHabilidade = -2; }

        if (valorHabilidade == 8 || valorHabilidade == 9){ modHabilidade = -1; }

        if (valorHabilidade == 10 || valorHabilidade == 11){ modHabilidade = 0; }

        if (valorHabilidade == 12 || valorHabilidade == 13){ modHabilidade = 1; }

        if (valorHabilidade == 14 || valorHabilidade == 15){ modHabilidade = 2; }

        if (valorHabilidade == 16 || valorHabilidade == 17){ modHabilidade = 3; }

        if (valorHabilidade == 18 || valorHabilidade == 19){ modHabilidade = 4; }

        if (valorHabilidade == 20 || valorHabilidade == 21){ modHabilidade = 5; }

        if (valorHabilidade == 22 || valorHabilidade == 23){ modHabilidade = 6; }

        if (valorHabilidade == 24 || valorHabilidade == 25){ modHabilidade = 7; }

        //...

        return modHabilidade;
    }


}
