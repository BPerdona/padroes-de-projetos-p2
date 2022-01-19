package flyweight;

import java.util.ArrayList;
import java.util.List;

public class Receita implements MyIngrediente{
    private String nomeReceita;
    private List<MyIngrediente> ingredientes;

    public Receita(String nomeReceita){
        this.nomeReceita=nomeReceita;
        this.ingredientes = new ArrayList<MyIngrediente>();
    }

    public void add(MyIngrediente i){
        ingredientes.add(i);
    }

    public String get(){
       String result = new String();
       for(MyIngrediente ing:ingredientes){
           result = result.concat(ing.get()+"\n");
       }
       return result;
    }

    public String getNomeReceita() {
        return nomeReceita;
    }

    public void setNomeReceita(String nomeReceita) {
        this.nomeReceita = nomeReceita;
    }
}
