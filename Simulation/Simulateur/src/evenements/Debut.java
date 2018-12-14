package evenements;


import util.Echeancier;
import util.Simulateur;

public class Debut extends Evenement {
    @Override
    public void run() {
        Simulateur.setB(false);
        Simulateur.setQ(0);

        Simulateur.setN(0);
        Simulateur.setAttGlb(0);
        Simulateur.setTempsMax(0);

        Simulateur.setTempsDebut(System.currentTimeMillis());

        Evenement arrClient = new ArrClient();
        Echeancier.ajouterEvenement(arrClient, Simulateur.getTempsActuel());
        arrClient.run();
    }
}
