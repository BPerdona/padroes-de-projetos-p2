package doubleDispatch;

public abstract class Insumo {
    private String nome;
    private Double peso;

    public Insumo(String nome, Double peso){
        super();
        this.nome=nome;
        this.peso=peso;
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
}
