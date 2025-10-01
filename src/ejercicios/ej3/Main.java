package ejercicios.ej3;

import java.util.Random;

public class Main {

    final static int NUM_VOTANTES = 10000;
    final static int NUM_PARTIDOS =5;

    public static void main(String[] args)
            throws InterruptedException {
        Urna urna;
        Votante votante;
        Random rand;
        Partido[] partidos;
        Votante[] votantes;
        int votosTotales=0;
        int votosRelativos=0;

        urna= new Urna(NUM_PARTIDOS);
        partidos = urna.getPartidos();
        rand = new Random();
        votantes= new Votante[NUM_VOTANTES];

        for( int i=0; i<NUM_VOTANTES; i++ ){
            votantes[i]=new Votante(partidos[rand.nextInt(partidos.length)], urna);
            votantes[i].start();
        }

        for(int i=0; i<NUM_VOTANTES; i++ )
            votantes[i].join();

        System.out.println("****************************************");
        for(int i = 0; i< NUM_PARTIDOS; i++){
            votosTotales+=votosRelativos= partidos[i].getVotos();
            System.out.println("Municipio "+(i+1)+" ha tenido "+votosRelativos+" votos");
        }
        System.out.println("****************************************");
        System.out.println("Votos totales: "+votosTotales);
        System.out.println("****************************************");
        System.out.println("Ganadores: ");
        getGanador(partidos);
    }

    private static void getGanador(Partido[] partidos){
        int max=0;
        for(int i = 0; i< NUM_PARTIDOS; i++ )
            if(partidos[i].getVotos()>max)
                max= partidos[i].getVotos();

        for(int i = 0; i< NUM_PARTIDOS; i++ )
            if(partidos[i].getVotos()==max)
                System.out.print((i+1)+" ");
    }
}
