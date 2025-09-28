package ejercicios.ej3;

public class Votante extends Thread {

    Municipio municipioAFavor;
    Urna urna;

    public Votante(Municipio municipioAFavor, Urna urna){
        this.municipioAFavor = municipioAFavor;
        this.urna = urna;
    }

    @Override
    public void run() {
        urna.votar(municipioAFavor);
    }
}
