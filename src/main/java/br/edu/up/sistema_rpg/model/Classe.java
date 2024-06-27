package br.edu.up.sistema_rpg.model;

import br.edu.up.sistema_rpg.model.utils.HabilidadesDeRaca;

import java.util.ArrayList;

public interface Classe {

    Integer calcularValorDePericias();

    Integer calcularModificadorDePericias();

    ArrayList<HabilidadesDeRaca> preencherHabilidades();

}
