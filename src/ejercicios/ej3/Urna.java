package ejercicios.ej3;

public class Urna {

    Partido[] partidos;

    public Urna(int num_Partidos){
        partidos = new Partido[num_Partidos];
        for(int i=0;i<num_Partidos;i++){
            partidos[i] = new Partido();
        }
    }

    public Partido[] getPartidos() {
        return partidos;
    }

    public void votar(Partido partido){
        partido.votar();
    }
}
