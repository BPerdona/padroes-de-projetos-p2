package doubleDispatch;

public abstract class Insumo {
    private String nome;
    private Double peso;
    private int quantidade;

    public Insumo(String nome, Double peso, int quantidade){
        super();
        this.nome=nome;
        this.peso=peso;
        this.quantidade=quantidade;
    }

    public void addPropriedades(Estoque estoque){
        estoque.addPropriedade(PropriedadesEstoque.QUANTIDADE, peso);
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

    public Double getPesoTotal(){
        return peso*quantidade;
    }
}
