package ejercicios.ej3;

import java.util.Random;

public class Main {

    final static int NUM_VOTANTES = 10000;
    final static int NUM_MUNICIPIOS=5;

    public static void main(String[] args)
            throws InterruptedException {
        Urna urna;
        Votante votante;
        Random rand;
        Municipio[] municipios;
        Votante[] votantes;
        int votosTotales=0;
        int votosRelativos=0;

        urna= new Urna(NUM_MUNICIPIOS);
        municipios= urna.getMunicipios();
        rand = new Random();
        votantes= new Votante[NUM_VOTANTES];

        for( int i=0; i<NUM_VOTANTES; i++ ){
            votantes[i]=new Votante(municipios[rand.nextInt(municipios.length)], urna);
            votantes[i].start();
        }

        for(int i=0; i<NUM_VOTANTES; i++ )
            votantes[i].join();

        System.out.println("****************************************");
        for(int i = 0; i<NUM_MUNICIPIOS; i++){
            votosTotales+=votosRelativos=municipios[i].getVotos();
            System.out.println("Municipio "+(i+1)+" ha tenido "+votosRelativos+" votos");
        }
        System.out.println("****************************************");
        System.out.println("Votos totales: "+votosTotales);
        System.out.println("****************************************");
        System.out.println("Ganadores: ");
        getGanador(municipios);
    }

    private static void getGanador(Municipio[] municipios){
        int max=0;
        for( int i=0; i<NUM_MUNICIPIOS; i++ )
            if(municipios[i].getVotos()>max)
                max=municipios[i].getVotos();

        for( int i=0; i<NUM_MUNICIPIOS; i++ )
            if(municipios[i].getVotos()==max)
                System.out.print((i+1)+" ");
    }
}
