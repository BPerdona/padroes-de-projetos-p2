package doubleDispatch;

public class InsumoPerecivel extends Insumo{
    private Double validadeDias;
    private Double custoEnergia;

    public InsumoPerecivel(String nome, Double peso, Double validadeDias, int quantidade, Double precoEnergia) {
        super(nome, peso, quantidade);
        this.validadeDias = validadeDias;
        this.custoEnergia = precoEnergia;
    }

    public void addPropriedades(Estoque estoque){
        super.addPropriedades(estoque);
        estoque.addPropriedade(PropriedadesEstoque.VALIDADE, validadeDias);
        estoque.addPropriedade(PropriedadesEstoque.CUSTOENEGIA, custoEnergia);
    }

    public Double getValidadeDias() {
        return validadeDias;
    }

    public void setValidadeDias(Double validadeDias) {
        this.validadeDias = validadeDias;
    }

    public Double getPrecoEnergia() {
        return custoEnergia;
    }

    public void setPrecoEnergia(Double precoEnergia) {
        this.custoEnergia = precoEnergia;
    }
}
