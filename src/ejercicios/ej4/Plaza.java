package ejercicios.ej4;

import java.util.Random;

public class Plaza {

    final static int TIEMPO_MIN_APARCADO=1000;
    final static int TIEMPO_MAX_APARCADO=5000;
    final Parking parking;
    static int num_Plazas=0;
    Random rand = new Random();
    int id;
    Conductor conductor;

    public Plaza(Parking parking) {
        num_Plazas++;
        id=num_Plazas;
        this.parking = parking;
    }

    public synchronized void aparcar(Conductor conductor) {
        synchronized (parking){
            this.conductor=conductor;
            parking.mostrarParking();
        }
        try {
            Thread.sleep(rand.nextInt(TIEMPO_MIN_APARCADO,TIEMPO_MAX_APARCADO));
        } catch (InterruptedException e) {
            throw new RuntimeException("Error en Thread.sleep");
        }
        synchronized (parking){
            this.conductor=null;
            parking.mostrarParking();
        }
    }

    public Conductor getConductor() {
        return conductor;
    }
}
