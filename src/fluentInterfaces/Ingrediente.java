package fluentInterfaces;

public class Ingrediente {
    private String nome;
    private String descricao;
    private Double quantidade;

    public Ingrediente named(String nome){
        this.nome = nome;
        return this;
    }

    public Ingrediente described(String descricao){
        this.descricao = descricao;
        return this;
    }

    public Ingrediente theAmount(Double quantidade){
        this.quantidade = quantidade;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getQuantidade() {
        return quantidade;
    }
}
