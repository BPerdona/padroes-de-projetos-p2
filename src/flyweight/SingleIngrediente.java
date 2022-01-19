package flyweight;

public class SingleIngrediente implements MyIngrediente{
    private final String nome;
    private final int quantidade;

    public SingleIngrediente(String nome, int quantidade){
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String get(){
        return "Nome: "+nome+" Quantidade: "+quantidade;
    }
}
