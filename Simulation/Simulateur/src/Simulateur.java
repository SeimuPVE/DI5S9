import evenements.Debut;

public class Simulateur {
    Echeancier echeancier;

    // Variables utilitaires.
    private static boolean B; // Vaut vrai quand le téléconseiller est occupé avec un client et faux si c’est libre.
    private static int Q; // Nombre de clients en attente.

    // Variables statistiques.
    private static double T; // Temps de la simulation.
    private static int N; // Nombre d'arrivées
    private static double AttGlb; // Attente globale des clients.
    private static double TempsMax; // Temps d'attente maximale d'un client.

    public Simulateur(double tempsDeSimulation) {
        B = false;
        Q = 0;

        T = tempsDeSimulation;
        N = 0;
        AttGlb = 0;
        TempsMax = 0;

        echeancier = new Echeancier();
        echeancier.add(new Debut());
    }

    public void run() {
        echeancier.get(0).run();
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
}
