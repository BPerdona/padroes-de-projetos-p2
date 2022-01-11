package commands;

public class ServicoBolo extends Produto{
    private String descricao;
    private Double entrega;

    public ServicoBolo(String nome, Double preco, String descricao, Double entrega){
        super(nome, preco);
        this.descricao = descricao;
        this.entrega = entrega;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getEntrega() {
        return entrega;
    }

    public void setEntrega(Double entrega) {
        this.entrega = entrega;
    }
}
