package ejercicios.ej4;

public class Conductor extends Thread {

    static int numConductores=0;

    int id;
    Parking parking;

    public Conductor(Parking parking) {
        numConductores++;
        id = numConductores;
        this.parking = parking;
    }

    public void run() {
        parking.aparcar(this);
    }

    public String toString() {
        return String.valueOf(id);
    }
}
