package evenements;

import util.Echeancier;
import util.Simulateur;


public class FinAppel extends Evenement {
    private double heure;

    public FinAppel(double heure) {
        this.heure = heure;
    }

    @Override
    public void run() {
        Simulateur.setB(false);

        if(Simulateur.getQ() > 0) {
            Evenement accesAppel = new AccesAppel(this.heure);
            Echeancier.ajouterEvenement(accesAppel, this.heure);
        }
    }
}
