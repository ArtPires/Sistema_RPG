package br.edu.up.sistema_rpg.model.racas;

import br.edu.up.sistema_rpg.model.Raca;
import br.edu.up.sistema_rpg.model.utils.Habilidades;

import java.util.ArrayList;

public class Elfo implements Raca {

    private final ArrayList<Habilidades> habilidadesArrayList = new ArrayList<>();

    public Elfo() { }

    @Override
    public ArrayList<Habilidades> ajusteDeHabilidades() {
        habilidadesArrayList.add(new Habilidades("Destreza", 4));
        habilidadesArrayList.add(new Habilidades("Inteligencia", 2));
        habilidadesArrayList.add(new Habilidades("Constituição", -2));
        return habilidadesArrayList;
    }
}
