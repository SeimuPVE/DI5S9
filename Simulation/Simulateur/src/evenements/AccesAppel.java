package evenements;

import clients.Clients;
import util.Echeancier;
import util.LoiSimulateur;
import util.Simulateur;


public class AccesAppel extends Evenement {
    private double heure;

    public AccesAppel(double heure) {
        this.heure = heure;

    }

    @Override
    public void run() {
        Simulateur.setQ(Simulateur.getQ() - 1);
        Simulateur.setB(true);

        if (Simulateur.getTempsActuel() - Clients.getClientAt(Simulateur.getN()).getDateArrSystem() > Simulateur.getTempsMax())
            Simulateur.setTempsMax(Simulateur.getTempsActuel() - Clients.getClientAt(Simulateur.getN()).getDateArrSystem());

        Simulateur.setAttGlb(Simulateur.getAttGlb() - Simulateur.getTempsActuel() - Clients.getClientAt(Simulateur.getN()).getDateArrSystem());
        Simulateur.setN(Simulateur.getN() + 1);

        double tempsService = LoiSimulateur.loi_exp(0.6);

        Evenement finAppel = new FinAppel(this.heure + tempsService);
        Echeancier.ajouterEvenement(finAppel, this.heure + tempsService);
    }
}
