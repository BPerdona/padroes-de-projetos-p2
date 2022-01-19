package facade;

import javax.crypto.spec.PSource;

public class Freezer implements Maquina {
    private int id;
    private Double temperatura;

    public Freezer(int id){
        this.id=id;
        this.temperatura=2.0;
        this.iniciar(temperatura);
    }

    @Override
    public void iniciar(Double value) {
        if(!verif(value)){
            System.out.println("A temperatura maxima do Freezer é 10C e a minima é -30C");
            return;
        }
        temperatura=value;
        System.out.println("O Freezer "+id+" foi iniciado automaticamente! Temperatura: "+this.temperatura);
    }

    @Override
    public void pausar() {
        System.out.println("O Freezer não pode 'Pausar'. Utilize 'finalizar()'");
    }

    @Override
    public void finalizar() {
        this.temperatura=0.0;
        System.out.println("O Freezer foi desligado com sucesso! Temperatura:"+this.temperatura);
    }

    public void alterar(Double value){
        if(!verif(value)) {
            System.out.println("A temperatura maxima do Freezer é 10C e a minima é -50C");
            return;
        }
        double aux = temperatura;
        this.temperatura=value;
        System.out.println("A temperatura foi altera de: "+aux+" para: "+this.temperatura+" com sucesso!");
    }

    private boolean verif(Double value){
        if(value > 10.0 || value < -50.0)
            return false;
        return true;
    }
}
