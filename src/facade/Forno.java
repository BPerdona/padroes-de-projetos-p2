package facade;

public class Forno implements Maquina {
    private int id;
    private Double temperatura;

    public Forno(int id){
        this.id=id;
        this.temperatura=0.0;
    }

    @Override
    public void iniciar(Double value) {
        this.temperatura=value;
        System.out.println("O Forno: "+this.id+" foi iniciado! Temperatura: "+this.temperatura);
    }

    @Override
    public void pausar() {
        System.out.println("A Forno: "+this.id+" foi parada! Temperatura: "+this.temperatura);
    }

    @Override
    public void finalizar() {
        temperatura=0.0;
        System.out.println("A Forno "+this.id+" finalizou sua execução! Temperatura: "+this.temperatura);
    }

    public void alterar(Double value){
        if(value > 800.0 || value < 50) {
            System.out.println("A temperatura maxima do forno é 800C e a minima é 50C");
            return;
        }
        double aux = temperatura;
        this.temperatura=value;
        System.out.println("A temperatura foi altera de: "+aux+" para: "+this.temperatura+" com sucesso!");
    }
}
