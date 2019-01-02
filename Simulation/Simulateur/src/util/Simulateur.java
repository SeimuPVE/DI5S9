package util;

import evenements.Debut;

import java.io.IOException;
import java.util.Collections;
import java.util.List;


public class Simulateur {
    // Configuration.
    private static boolean fromFile = true;
    private static String filePath = "src/ressources/DataAppels.txt";
    public static double lambda_exp_arr_client = 0.4;
    public static double lambda_exp_acces_appel = 0.6;

    // Variables utilitaires.
    private static boolean B = false; // Vaut vrai quand le téléconseiller est occupé avec un clients et faux si c’est libre.
    private static int Q; // Nombre de clients en attente.
    private static long tempsDebut; // Temps de lancement de la simulation.

    // Variables statistiques.
    private static double T; // Temps de la simulation.
    private static int N; // Nombre d'arrivées
    private static double AttGlb; // Attente globale des clients.
    private static double TempsMax; // Temps d'attente maximale d'un clients.

    public Simulateur() {
        // Rien à faire, ce constructeur sert juste à créer un simulateur pour appeler les variables statiques.
    }

    public Simulateur(double tempsDeSimulation) {
        T = tempsDeSimulation;
        Echeancier.ajouterEvenement(new Debut(), 0);

        // Initialisation du parseur.
        try {
            Parseur parseur;
            if(isFromFile())
                parseur = new Parseur(filePath);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        List<Pair> echeancier = Echeancier.getEvenements();

        while(!echeancier.isEmpty() || (isFromFile() && !Parseur.finLecture() && !echeancier.isEmpty())) {
            echeancier.get(0).getEvenement().run();

            System.out.println(echeancier.get(0).getEvenement().getClass().getName() + " at "+ echeancier.get(0).getDate());

            echeancier.remove(0);
            Collections.sort(echeancier);
        }
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
