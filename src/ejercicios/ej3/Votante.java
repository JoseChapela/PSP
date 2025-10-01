package ejercicios.ej3;

public class Votante extends Thread {

    Partido partidoAFavor;
    Urna urna;

    public Votante(Partido partidoAFavor, Urna urna){
        this.partidoAFavor = partidoAFavor;
        this.urna = urna;
    }

    @Override
    public void run() {
        urna.votar(partidoAFavor);
    }
}
