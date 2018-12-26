package evenements;

import parseur.Parseur;
import util.Echeancier;
import util.LoiSimulateur;
import util.Simulateur;

import java.io.IOException;


public class Debut extends Evenement {
    @Override
    public void run() {
        double interArrivee;

        try {
            Parseur parseur = new Parseur("src/ressources/DataAppels.txt");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Simulateur.setB(false);
        Simulateur.setQ(0);

        Simulateur.setN(0);
        Simulateur.setAttGlb(0);
        Simulateur.setTempsMax(0);

        Simulateur.setTempsDebut(System.currentTimeMillis());

        interArrivee = LoiSimulateur.loi_exp(0.4);
        Evenement arrClient = new ArrClient((long) interArrivee);
        Echeancier.ajouterEvenement(arrClient, (long)interArrivee);
    }
}
