package br.edu.up.sistema_rpg.model.classes;

import br.edu.up.sistema_rpg.model.Classe;
import br.edu.up.sistema_rpg.model.utils.HabilidadesDeRaca;
import br.edu.up.sistema_rpg.model.utils.Modificadores;
import br.edu.up.sistema_rpg.model.utils.Pericias;

import java.util.ArrayList;
import java.util.List;

public class Guerreiro implements Classe {

    private static final Integer PERICIAS_TREINADAS = 2;
    private final List<Pericias> pericias = new ArrayList<>();
    private final ArrayList<HabilidadesDeRaca> habilidadesDeRaca = new ArrayList<>();

    public Guerreiro() {  }

    public static Integer calcularPericiasTreinadas(Integer modificadorInteligencia) {
        return PERICIAS_TREINADAS + Modificadores.calcModificador(modificadorInteligencia);
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
        habilidadesDeRaca.add(new HabilidadesDeRaca("Técnica de Luta", "Recebe 1 talento de combate"));
        return habilidadesDeRaca;
    }
}
