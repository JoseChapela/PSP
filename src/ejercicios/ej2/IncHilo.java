package ejercicios.ej2;

public class IncHilo extends Thread {

    final int NUM_INCREMENTOS=10;
    Contador contador;

    public IncHilo(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        for(int i=0;i<NUM_INCREMENTOS;i++) {
            contador.incrementar();
        }
    }
}
