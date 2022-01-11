package commands;

import java.util.ArrayList;

public class Carrinho {
    public ArrayList<ProdutoPronto> produtoProntos;
    private Double desconto;
    private Double precoTotal;

    public Carrinho(){
        this.produtoProntos = new ArrayList<ProdutoPronto>();
        this.desconto = 0.0;
        this.precoTotal = 0.0;
    }

    public ArrayList<ProdutoPronto> getProdutos() {
        return produtoProntos;
    }

    public void setProdutos(ArrayList<ProdutoPronto> produtoProntos) {
        this.produtoProntos = produtoProntos;
        calcularTotal();
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getPrecoTotal() {
        calcularTotal();
        return precoTotal;
    }

    //Modificado para retornar a soma de todos os valores
    private void calcularTotal(){
        Double total = 0.0;
        if(produtoProntos.isEmpty()){
            precoTotal = total;
            return;
        }
        for(ProdutoPronto p : produtoProntos){
            total+=p.getPreco();
        }
        total = total - (total*(desconto/100));
        precoTotal = total;
    }
}
