package commands;

import java.util.ArrayList;

public interface Comando {
    public ArrayList<ProdutoPronto> adicionar();
    public ArrayList<ProdutoPronto> remover();
}
