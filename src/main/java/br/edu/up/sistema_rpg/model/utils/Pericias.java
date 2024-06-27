package br.edu.up.sistema_rpg.model.utils;

public class Pericias {

    private String nome;
    private Integer valorTotal;
    private Boolean treinada;
    private Boolean somenteTreinada;

    private Integer graduacao;

    public Pericias(String nome, Integer valorTotal, Boolean treinada, Boolean somenteTreinada) {
        this.nome = nome;
        this.valorTotal = valorTotal;
        this.treinada = treinada;
        this.somenteTreinada = somenteTreinada;
    }

    //Gets e Sets
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Boolean getTreinada() {
        return treinada;
    }

    public void setTreinada(Boolean treinada) {
        this.treinada = treinada;
    }

    public Boolean getSomenteTreinada() {
        return somenteTreinada;
    }

    public void setSomenteTreinada(Boolean somenteTreinada) {
        this.somenteTreinada = somenteTreinada;
    }

    @Override
    public String toString() {
        return "Pericia{" +
                "nome='" + nome + '\'' +
                ", valor=" + valorTotal +
                '}';
    }
}
