package ejercicios.ej3;

import java.util.Random;

public class Votacion{

    private final static int NUM_MUNICIPIOS=5;
    private final static int NUM_VOTANTES=1000;
    private final static int SLEEP_MILISECS=500;
    private final static int[] votesMunicipio = new int[NUM_MUNICIPIOS];
    private final static Thread[] votantes = new Thread[NUM_VOTANTES];

    public static void main(String[] args)
            throws InterruptedException {

        Random rand = new Random();
        int votesTotal=0;

        for (int i = 0; i < NUM_VOTANTES; i++) {
            votantes[i] =new Thread(()->{
                try {
                    Thread.sleep(rand.nextInt(SLEEP_MILISECS));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                votar(rand.nextInt(NUM_MUNICIPIOS));
            });
            votantes[i].start();
        }
        for (int i = 0; i < NUM_VOTANTES; i++) {
            votantes[i].join();
        }
        for(int i = 0; i < NUM_MUNICIPIOS; i++) {
            System.out.println("MUNICIPIO " + (i + 1) + " --> " + votesMunicipio[i]);
            votesTotal += votesMunicipio[i];
        }
        System.out.println(votesTotal);
    }

    public synchronized static void votar(int idMunicipio){
        votesMunicipio[idMunicipio]++;
    }
}
