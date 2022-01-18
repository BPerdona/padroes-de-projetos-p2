package doubleDispatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estoque {
    private List<Insumo> insumos;
    private Map<PropriedadesEstoque, Double> propriedades;

    public void addInsumo(Insumo insumo){
        getInsumos().add(insumo);
        insumo.addPropriedades(this);
    }

    public void addPropriedade(PropriedadesEstoque tipo, double peso){
        getPropriedades().put(tipo, getPropriedades().get(tipo)+peso);
    }

    public double getPesoTotal(){
        if(insumos.isEmpty()){
            return 0.0;
        }
        double pesoTotal = 0.0;
        pesoTotal += getPropriedades().get(PropriedadesEstoque.PESO);
        return pesoTotal;
    }

    public List<Insumo> getInsumos() {
        if(insumos == null)
            insumos = new ArrayList<Insumo>();
        return insumos;
    }

    public void setInsumos(List<Insumo> insumos) {
        this.insumos = insumos;
    }

    public Map<PropriedadesEstoque, Double> getPropriedades() {
        if(propriedades == null){
            propriedades = new HashMap<PropriedadesEstoque, Double>();
            for(PropriedadesEstoque tipo : PropriedadesEstoque.values())
                propriedades.put(tipo, 0.0);
        }
        return propriedades;
    }

    public void setPropriedades(Map<PropriedadesEstoque, Double> propriedades) {
        this.propriedades = propriedades;
    }
}
