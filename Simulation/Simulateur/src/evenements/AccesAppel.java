package evenements;


public class AccesAppel extends Evenement {
    /*
     * Q <- Q - 1
     * B <- 1
     * Si HS - Client.DateArrivée > TempsMax alors
     *     TempsMax <- HS - Client(n).DateArrivée
     * FinSi
     * AttGlb <- AttGlb + HS - Client(n).DateArrivée
     * N <- N + 1
     * Créer un événement FinAppel à l’heure HS + TODO et l’insérer dans l’échéancier
     */
    public AccesAppel() {

    }

    @Override
    public void run() {

    }
}
