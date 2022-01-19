package facade;

public class ControladorMaquina {
    private Batedeira batedeira;
    private Forno forno;
    private Freezer freezer;

    public ControladorMaquina(){
        batedeira=new Batedeira(27);
        forno=new Forno(13);
        freezer=new Freezer(2);
    }

    public void iniciarForno(Double value){
        forno.iniciar(value);
    }

    public void iniciarbatedeira(Double value){
        batedeira.iniciar(value);
    }

    public void iniciarFrezeer(Double value){
        freezer.iniciar(value);
    }

    public void pausarForno(){
        forno.pausar();
    }

    public void pausarBatedeira(){
        batedeira.pausar();
    }
    public void pausarFreezer(){
        freezer.pausar();
    }

    public void finalizarForno(){
        forno.finalizar();
    }

    public void finalizarBatedeira(){
        batedeira.finalizar();
    }

    public void finalizarFreezer(){
        freezer.finalizar();
    }

    public void mudarVelocidadeBatedeira(Double value){
        batedeira.alterar(value);
    }

    public void mudarTemperaturaForno(Double value){
        forno.alterar(value);
    }

    public void mudarTemperaturaFreezer(double value){
        freezer.alterar(value);
    }

}
