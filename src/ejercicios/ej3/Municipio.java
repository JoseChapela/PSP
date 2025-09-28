package ejercicios.ej3;

public class Municipio{

    private int votos =0;

    public synchronized void votar(){
        votos++;
    }

    public int getVotos(){
        return votos;
    }

}
