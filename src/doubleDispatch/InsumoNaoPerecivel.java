package doubleDispatch;

public class InsumoNaoPerecivel extends Insumo{
    private Double precoEstoque;

    public InsumoNaoPerecivel(String nome, Double peso, int quantidade, Double pesoLiquido) {
        super(nome, peso, quantidade);
        this.precoEstoque = pesoLiquido;
    }

    public void addPropriedades(Estoque estoque){
        super.addPropriedades(estoque);
        estoque.addPropriedade(PropriedadesEstoque.PRECOESTOQUE, precoEstoque);
    }
}
