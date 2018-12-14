package evenements;

import clients.Clients;
import util.Echeancier;
import util.Simulateur;


public class AccesAppel extends Evenement {
    @Override
    public void run() {
        Simulateur.setQ(Simulateur.getQ() - 1);
        Simulateur.setB(true);

        if(Simulateur.getTempsActuel() - Clients.getClientAt(Simulateur.getN()).getDateArrSystem() > Simulateur.getTempsMax())
            Simulateur.setTempsMax(Simulateur.getTempsActuel() - Clients.getClientAt(Simulateur.getN()).getDateArrSystem());

        Simulateur.setAttGlb(Simulateur.getAttGlb() - Simulateur.getTempsActuel() - Clients.getClientAt(Simulateur.getN()).getDateArrSystem());
        Simulateur.setN(Simulateur.getN() + 1);

        Evenement finAppel = new FinAppel();
        Echeancier.ajouterEvenement(finAppel, Simulateur.getTempsActuel());
        finAppel.run();
    }
}
