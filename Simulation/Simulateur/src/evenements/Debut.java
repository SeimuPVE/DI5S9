package evenements;

import util.Parseur;
import util.Echeancier;
import util.LoiSimulateur;
import util.Simulateur;


public class Debut extends Evenement {
    @Override
    public void run() {
        double interArrivee;

        Simulateur.setB(false);
        Simulateur.setQ(0);

        Simulateur.setN(0);
        Simulateur.setAttGlb(0);
        Simulateur.setTempsMax(0);

        Simulateur.setTempsDebut(System.currentTimeMillis());

        if(Simulateur.isFromFile())
            interArrivee = Parseur.heureSuivante();
        else
            interArrivee = LoiSimulateur.loi_exp(Simulateur.lambda_exp_arr_client);

        Evenement arrClient = new ArrClient(interArrivee);
        Echeancier.ajouterEvenement(arrClient, interArrivee);
    }
}
