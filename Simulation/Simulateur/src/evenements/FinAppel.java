package evenements;


import util.Echeancier;
import util.Simulateur;

public class FinAppel extends Evenement {
    @Override
    public void run() {
        Simulateur.setB(false);

        if(Simulateur.getQ() > 0) {
            Evenement accesAppel = new AccesAppel();
            Echeancier.ajouterEvenement(accesAppel, Simulateur.getTempsActuel());
            accesAppel.run();
        }
    }
}
