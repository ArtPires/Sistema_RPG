package br.edu.up.sistema_rpg.model.utils;

public class HabilidadesDeRaca {

    private String nome;
    private String descricao;

    public HabilidadesDeRaca(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Habilidade{" +
                "nome='" + nome + '\'' +
                ", descrição=" + descricao +
                '}';
    }
}
