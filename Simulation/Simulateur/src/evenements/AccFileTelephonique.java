package evenements;

import clients.Clients;
import util.Echeancier;
import util.Simulateur;


public class AccFileTelephonique extends Evenement {
    private double heure;


    public AccFileTelephonique(double heure) {
        this.heure = heure;
    }

    @Override
    public void run() {
        Simulateur.setQ(Simulateur.getQ() + 1);
        Simulateur.setAireClientsDansFile(Simulateur.getAireClientsDansFile() + Simulateur.getQ());

        if (!Simulateur.isB()) {
            Evenement accesAppel = new AccesAppel(this.heure);
            Echeancier.ajouterEvenement(accesAppel, this.heure);
        }
    }
}
