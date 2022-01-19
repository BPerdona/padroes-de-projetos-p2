package flyweight;

import java.util.HashMap;
import java.util.Map;

public class IngredienteFactory {
    private static Map<String, SingleIngrediente> ingredientes;

    private static void init(){
        ingredientes = new HashMap<String, SingleIngrediente>();
        ingredientes.put("morango", new SingleIngrediente("Morango",3));
        ingredientes.put("trigo",new SingleIngrediente("Trigo",5));
        ingredientes.put("fermento",new SingleIngrediente("Fermento", 1));
        ingredientes.put("acucar",new SingleIngrediente("Açucar", 1));
        ingredientes.put("leite",new SingleIngrediente("Leite", 3));
        ingredientes.put("ovo",new SingleIngrediente("Ovo",6));
        ingredientes.put("sal",new SingleIngrediente("Sal",1));
    }

    public static SingleIngrediente get(String name){
        if(ingredientes==null)
            init();
        return ingredientes.get(name);
    }
}
