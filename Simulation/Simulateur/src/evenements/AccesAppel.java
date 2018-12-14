package evenements;

import util.Echeancier;
import util.Simulateur;


// HS = heure simulation.
public class AccesAppel extends Evenement {
    @Override
    public void run() {
        Simulateur.setQ(Simulateur.getQ() - 1);
        Simulateur.setB(true);

        if(1 == 1) // Si HS - Client.DateArrivée > TempsMax alors...
            System.out.println("TODO."); // TempsMax <- HS - Client(n).DateArrivée.

        // AttGlb <- AttGlb + HS - Client(n).DateArrivée.
        Simulateur.setN(Simulateur.getN() + 1);

        Evenement finAppel = new FinAppel();
        Echeancier.ajouterEvenement(finAppel, Simulateur.getTempsActuel());
        finAppel.run();
    }
}
