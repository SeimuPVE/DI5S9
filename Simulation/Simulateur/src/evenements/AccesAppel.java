package evenements;

import util.Simulateur;


// HS = heure simulation.
public class AccesAppel extends Evenement {
    public AccesAppel() {
        // Rien à faire lors de la création, on peut lancer directement.
    }

    @Override
    public void run() {
        Simulateur.setQ(Simulateur.getQ() - 1);
        Simulateur.setB(true);

        if() // Si HS - Client.DateArrivée > TempsMax alors...
            System.out.println("TODO."); // TempsMax <- HS - Client(n).DateArrivée.

        // AttGlb <- AttGlb + HS - Client(n).DateArrivée.
        Simulateur.setN(Simulateur.getN() + 1);
        // Créer un événement FinAppel à l’heure HS + TODO et l’insérer dans l’échéancier.
    }
}
