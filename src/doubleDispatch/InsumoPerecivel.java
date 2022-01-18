package doubleDispatch;

public class InsumoPerecivel extends Insumo{
    private int validadeDias;
    private Double custoEnergia;

    public InsumoPerecivel(String nome,Double preco, Double peso, int validadeDias, int quantidade, Double precoEnergia) {
        super(nome,preco , peso, quantidade);
        this.validadeDias = validadeDias;
        this.custoEnergia = precoEnergia;
    }

    public void addPropriedades(Estoque estoque){
        super.addPropriedades(estoque);
        estoque.addPropriedade(PropriedadesEstoque.VALIDADE, validadeDias);
        estoque.addPropriedade(PropriedadesEstoque.CUSTOENEGIA, custoEnergia);
    }

    public int getValidadeDias() {
        return validadeDias;
    }

    public void setValidadeDias(int validadeDias) {
        this.validadeDias = validadeDias;
    }

    public Double getPrecoEnergia() {
        return custoEnergia;
    }

    public void setPrecoEnergia(Double precoEnergia) {
        this.custoEnergia = precoEnergia;
    }
}
