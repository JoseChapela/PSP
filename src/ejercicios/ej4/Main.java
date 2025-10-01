package ejercicios.ej4;

public class Main {

    //ATRIBUTOS
    final static int NUM_PLAZAS=10;
    final static int CONDUCTORES=50;

    public static void main(String[] args) {

        Parking parking = new Parking(NUM_PLAZAS);
        Conductor[] conductores = new Conductor[CONDUCTORES];

        for(int i=0;i<CONDUCTORES;i++){
            conductores[i] = new Conductor(parking);
            conductores[i].start();
        }
    }
}
