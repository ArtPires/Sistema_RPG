package br.edu.up.sistema_rpg.model.classes;

import br.edu.up.sistema_rpg.model.Classe;
import br.edu.up.sistema_rpg.model.utils.Pericias;

import java.util.ArrayList;
import java.util.List;

public class Guerreiro implements Classe {

    private static final Integer PERICIAS_TREINADAS = 2;
    private List<Pericias> pericias = new ArrayList<>();

    public Guerreiro() {
        adicionarPericias();
    }

    public static Integer calcularPericiasTreinadas(Integer modificadorInteligencia) {
        return PERICIAS_TREINADAS + modificadorInteligencia;
    }

    @Override
    public void adicionarPericias() {

    }

    @Override
    public Integer calcularValorDePericias() {
        return 0;
    }
}
