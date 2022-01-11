package commands;

import java.util.ArrayList;
import java.util.Stack;

public class ExecutorComands {
    private Stack<Comando> feitos;
    private Stack<Comando> desfeitos;

    public ExecutorComands(){
        super();
        this.feitos = new Stack<Comando>();
        this.desfeitos = new Stack<Comando>();
    }

    public ArrayList<ProdutoPronto> adicionar(Comando c){
        feitos.push(c);
        desfeitos.clear();
        return c.adicionar();
    }

    public ArrayList<ProdutoPronto> desfazer(){
        if(feitos.isEmpty())
            return null;

        Comando c = feitos.pop();
        desfeitos.push(c);
        return  c.remover();
    }

    public ArrayList<ProdutoPronto> refazer(){
        if(desfeitos.isEmpty())
            return null;

        Comando c = desfeitos.pop();
        feitos.push(c);
        return c.adicionar();
    }
}
