package util;

import clients.Clients;
import evenements.Debut;
import evenements.Fin;

import java.io.IOException;
import java.util.Collections;
import java.util.List;


public class Simulateur {
    // Configuration.
    private static boolean fromFile = false;
    private static String filePath;
    public static double lambda_exp_arr_client = 0.4;
    public static double lambda_exp_acces_appel = 0.6;
    public static double alpha_acces_appel = 2.5;
    public static double beta_acces_appel = 6.4;


    // Variables utilitaires.
    private static boolean isEnded = false;
    private static boolean B = false; // Vaut vrai quand le téléconseiller est occupé avec un client et faux si c’est libre.
    private static int Q; // Nombre de clients en attente.
    private static long tempsDebut; // Temps de lancement de la simulation.

    // Variables statistiques.
    private static double T; // Temps de la simulation.
    private static int N; // Nombre d'arrivées
    private static double AttGlb; // Attente globale des clients.
    private static double TempsMax; // Temps d'attente maximale d'un client.

    private static double AireClientsDansFile; // Nombre total de clients dans la file.
    private static double AireOccupationConseiller; // Temps total d'occupation du téléconseiller.


    public Simulateur(double tempsDeSimulation) {
        fromFile = false;
        T = tempsDeSimulation;
        Echeancier.ajouterEvenement(new Debut(), 0);
    }

    public Simulateur(String filePath) {
        Echeancier.ajouterEvenement(new Debut(), 0);

        // Initialisation du parseur.
        try {
            new Parseur(filePath);
            fromFile = true;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        List<Pair> echeancier = Echeancier.getEvenements();

        while((!isFromFile() && !isEnded) || (isFromFile() && !echeancier.isEmpty())) {
            echeancier.get(0).getEvenement().run();

            System.out.println(echeancier.get(0).getEvenement().getClass().getName() + " at "+ echeancier.get(0).getDate());

            if (isFromFile())
                T = echeancier.get(0).getDate();

            echeancier.remove(0);
            Collections.sort(echeancier);
        }

        new Fin().run();
    }

    /*
     * Getters and setters.
     */
    public static boolean isB() {
        return B;
    }

    public static void setB(boolean b) {
        Simulateur.B = b;
    }

    public static int getQ() {
        return Q;
    }

    public static void setQ(int q) {
        Q = q;
    }

    public static long getTempsDebut() {
        return tempsDebut;
    }

    public static void setTempsDebut(long currentTimeMillis) {
        tempsDebut = currentTimeMillis;
    }

    public static double getT() {
        return T;
    }

    public static void setT(double t) {
        T = t;
    }

    public static int getN() {
        return N;
    }

    public static void setN(int n) {
        N = n;
    }

    public static void setIsEnded(boolean end)
    {
        isEnded = end;
    }

    public static double getAttGlb() {
        return AttGlb;
    }

    public static void setAttGlb(double attGlb) {
        AttGlb = attGlb;
    }

    public static double getTempsMax() {
        return TempsMax;
    }

    public static void setTempsMax(double tempsMax) {
        TempsMax = tempsMax;
    }

    public static long getTempsActuel() {
        return System.currentTimeMillis() - tempsDebut;
    }

    public static void setAireClientsDansFile(double aireClientsDansFile)
    {
        AireClientsDansFile = aireClientsDansFile;
    }

    public static double getAireClientsDansFile() { return AireClientsDansFile; }

    public static void setAireOccupationConseiller(double aireOccupationConseiller)
    {
        AireOccupationConseiller = aireOccupationConseiller;
    }

    public static double getAireOccupationConseiller() { return AireOccupationConseiller; }

    public static boolean isFromFile() {
        return fromFile;
    }

    public static void setFromFile(boolean fromFile) {
        Simulateur.fromFile = fromFile;
    }

    public static String getFilePath() {
        return filePath;
    }

    public static void setFilePath(String filePath) {
        Simulateur.filePath = filePath;
    }
}
