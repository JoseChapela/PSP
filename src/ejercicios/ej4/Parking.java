package ejercicios.ej4;

import java.util.Random;

public class Parking {

    Plaza[] plazas;
    Random rand = new Random();

    public Parking(int num_plazas) {
        plazas = new Plaza[num_plazas];
        for (int i = 0; i < num_plazas; i++) {
            plazas[i] = new Plaza(this);
        }
    }

    public void aparcar(Conductor conductor) {
            plazas[rand.nextInt(plazas.length)].aparcar(conductor);
    }

    public void mostrarParking() {
        for (Plaza plaza : plazas) {
            if (plaza.getConductor()== null)
                System.out.print(" |---| ");
            else
                System.out.printf(" |%3d| ", Integer.valueOf(plaza.getConductor().toString()));
        }
        System.out.println();
    }
}
