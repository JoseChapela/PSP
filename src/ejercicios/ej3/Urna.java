package ejercicios.ej3;

public class Urna {

    Municipio[] municipios;

    public Urna(int num_Municipios){
        municipios = new Municipio[num_Municipios];
        for(int i=0;i<num_Municipios;i++){
            municipios[i] = new Municipio();
        }
    }

    public Municipio[] getMunicipios() {
        return municipios;
    }

    public void votar(Municipio municipio){
        municipio.votar();
    }
}
