package br.edu.up.sistema_rpg.model.classes;

import br.edu.up.sistema_rpg.model.Classe;
import br.edu.up.sistema_rpg.model.utils.HabilidadesDeRaca;
import br.edu.up.sistema_rpg.model.utils.Modificadores;

import java.util.ArrayList;

public class Bardo implements Classe {

    private static final Integer PERICIAS_TREINADAS = 6;
    private static final Integer PONTOS_DE_VIDA = 12;

    public static Integer calcularPericiasTreinadas(Integer valorInteligencia) {
        return PERICIAS_TREINADAS + Modificadores.calcModificador(valorInteligencia);
    }

    public static Integer calcularPV(Integer valorConstituicao) {
        return PONTOS_DE_VIDA + Modificadores.calcModificador(valorConstituicao);
    }

    @Override
    public Integer calcularValorDePericias() {
        return 0;
    }

    @Override
    public Integer calcularModificadorDePericias() {
        return 0;
    }

    @Override
    public ArrayList<HabilidadesDeRaca> preencherHabilidades() {
        return null;
    }
}
