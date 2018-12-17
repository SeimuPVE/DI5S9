package evenements;

import util.Echeancier;
import util.Simulateur;


public class FinAppel extends Evenement {
    private long heure;
    public FinAppel(long heure) {
        this.heure = heure;
    }

    @Override
    public void run() {
        Simulateur.setB(false);

        if(Simulateur.getQ() > 0) {
            Evenement accesAppel = new AccesAppel(this.heure);
            Echeancier.ajouterEvenement(accesAppel, this.heure);
//            accesAppel.run();
        }
    }
}
