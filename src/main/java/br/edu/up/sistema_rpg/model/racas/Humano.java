package br.edu.up.sistema_rpg.model.racas;

import br.edu.up.sistema_rpg.model.Raca;
import br.edu.up.sistema_rpg.model.utils.Habilidades;

import java.util.ArrayList;

public class Humano implements Raca {

    private final ArrayList<Habilidades> habilidadesArrayList = new ArrayList<>();

    public Humano() { }

    @Override
    public ArrayList<Habilidades> ajusteDeHabilidades() {
        habilidadesArrayList.add(new Habilidades("Destreza", 2));
        habilidadesArrayList.add(new Habilidades("Carisma", 2));
        return habilidadesArrayList;
    }
}
