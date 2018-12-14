package util;

import evenements.Debut;


public class Simulateur {

    // Variables utilitaires.
    private static boolean B; // Vaut vrai quand le téléconseiller est occupé avec un clients et faux si c’est libre.
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
    }

    public void run() {
        Echeancier.get(0).run();
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
}
