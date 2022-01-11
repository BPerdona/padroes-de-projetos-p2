package commands;

import java.util.ArrayList;

public class InserirBolo implements Comando{
    private ArrayList<ProdutoPronto> produtosCarrinho;
    private ServicoBolo novoServicoBolo;

    public InserirBolo(ArrayList<ProdutoPronto> produtosCarrinho, ServicoBolo novoServicoBolo){
        super();
        this.produtosCarrinho = produtosCarrinho;
        this.novoServicoBolo = novoServicoBolo;
    }

    @Override
    public ArrayList<ProdutoPronto> adicionar() {
        ProdutoPronto pp = new ProdutoPronto(novoServicoBolo.getNome()+" - "+novoServicoBolo.getDescricao(),novoServicoBolo.getPreco()+ novoServicoBolo.getEntrega());
        produtosCarrinho.add(pp);
        return produtosCarrinho;
    }

    @Override
    public ArrayList<ProdutoPronto> remover() {
        ArrayList<ProdutoPronto> antigaLista = produtosCarrinho;
        antigaLista.remove(produtosCarrinho.size()-1);
        return antigaLista;
    }
}
