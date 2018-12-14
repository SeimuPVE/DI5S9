package evenements;


import util.Echeancier;
import util.Simulateur;

public class AccFileTelephonique extends Evenement {
    @Override
    public void run() {
        Simulateur.setQ(Simulateur.getQ() - 1);

        if(!Simulateur.isB()) {
            Evenement accesAppel = new AccesAppel();
            Echeancier.ajouterEvenement(accesAppel, Simulateur.getTempsActuel());
            accesAppel.run();
        }
    }
}
