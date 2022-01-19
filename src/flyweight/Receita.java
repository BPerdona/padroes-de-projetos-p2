package flyweight;

import java.util.ArrayList;
import java.util.List;

public class Receita implements MyIngrediente{
    private List<MyIngrediente> ingredientes;

    public Receita(){
        this.ingredientes = new ArrayList<MyIngrediente>();
    }

    public void add(MyIngrediente i){
        ingredientes.add(i);
    }

    public String get(){
       String result = new String();
       for(MyIngrediente ing:ingredientes){
           result = result.concat("\n"+ing.get());
       }
       return result;
    }
}
