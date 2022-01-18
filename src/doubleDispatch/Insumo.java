package doubleDispatch;

public abstract class Insumo {
    private String nome;
    private Double preco;
    private Double peso;
    private int quantidade;

    public Insumo(String nome,Double preco, Double peso, int quantidade){
        super();
        this.nome=nome;
        this.preco=preco;
        this.peso=peso;
        this.quantidade=quantidade;
    }

    public void addPropriedades(Estoque estoque){
        estoque.addPropriedade(PropriedadesEstoque.PESO, peso*quantidade);
        estoque.addPropriedade(PropriedadesEstoque.PRECO, preco*quantidade);
        estoque.addPropriedade(PropriedadesEstoque.QUANTIDADE, quantidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
