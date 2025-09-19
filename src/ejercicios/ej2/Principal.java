package ejercicios.ej2;

public class Principal {

    final static int NUM_HILOS=10;
    final static Contador contador=new Contador();

    public static void main(String[] args) throws InterruptedException {

        for(int i=0; i<NUM_HILOS; i++){
            IncHilo hilo = new IncHilo(contador);
            hilo.start();
            hilo.join();
            System.out.println(contador.getContador());
        }
    }
}
