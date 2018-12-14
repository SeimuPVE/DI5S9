package evenements;


import util.Echeancier;
import util.Simulateur;

public class Debut extends Evenement {
    public Debut() {

    }

    @Override
    public void run() {
        Evenement arrClient = new ArrClient();
        Echeancier.ajouterEvenement(arrClient, Simulateur.getTempsActuel());
        arrClient.run();
    }
}
