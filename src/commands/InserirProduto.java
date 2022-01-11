package commands;

import java.util.ArrayList;

public class InserirProduto implements Comando{
    private ArrayList<ProdutoPronto> produtosCarrinho;
    private ProdutoPronto novoProdutoPronto;

    public InserirProduto(ArrayList<ProdutoPronto> produtosCarrinho, ProdutoPronto novoProdutoPronto){
        super();
        this.produtosCarrinho = produtosCarrinho;
        this.novoProdutoPronto = novoProdutoPronto;
    }

    @Override
    public ArrayList<ProdutoPronto> adicionar() {
        produtosCarrinho.add(novoProdutoPronto);
        return produtosCarrinho;
    }

    @Override
    public ArrayList<ProdutoPronto> remover() {
        ArrayList<ProdutoPronto> antigosProdutoProntos = produtosCarrinho;
        antigosProdutoProntos.remove(produtosCarrinho.size()-1);
        return antigosProdutoProntos;
    }
}
