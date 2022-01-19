package facade;

public class Batedeira implements Maquina {
    private int id;
    private int velocidade;

    public Batedeira(int id){
        this.id=id;
        this.velocidade=0;
    }


    @Override
    public void iniciar(Double value) {
        this.velocidade = value.intValue();
        System.out.println("O Batedeira: "+this.id+" foi iniciado! Velocidade: "+this.velocidade);
    }

    @Override
    public void pausar() {
        velocidade=0;
        System.out.println("O Batedeira: "+this.id+" foi pausada!");
    }

    @Override
    public void finalizar() {
        velocidade=0;
        System.out.println("O Batedeira: "+this.id+" foi Finalizada com sucesso! Velocidade: "+this.velocidade);
    }

    public void alterar(Double value){
        if(!verif(value)) {
            System.out.println("A Velocidade maxima da batedeira é 5 e a minima é 1");
            return;
        }
        int aux = velocidade;
        this.velocidade=value.intValue();
        System.out.println("A Velocidade foi altera de: "+aux+" para: "+this.velocidade+" com sucesso!");
    }

    private boolean verif(double value){
        if(value >= 6 || value < 0)
            return false;
        return true;
    }
}
