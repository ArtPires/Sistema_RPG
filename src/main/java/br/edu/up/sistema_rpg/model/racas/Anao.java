package br.edu.up.sistema_rpg.model.racas;

import br.edu.up.sistema_rpg.model.Raca;
import br.edu.up.sistema_rpg.model.utils.arquivos.Habilidades;

import java.util.ArrayList;

public class Anao implements Raca {

    private final ArrayList<Habilidades> habilidadesArrayList = new ArrayList<>();

    public Anao() { }

    @Override
    public ArrayList<Habilidades> ajusteDeHabilidades() {
        habilidadesArrayList.add(new Habilidades("Constituição", 4));
        habilidadesArrayList.add(new Habilidades("Sabedoria", 2));
        habilidadesArrayList.add(new Habilidades("Destreza", -2));
        return habilidadesArrayList;
    }
}
