package evenements;


import util.Echeancier;
import util.LoiSimulateur;
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

        double interArrivee = LoiSimulateur.loi_exp(0.4);

        Evenement arrClient = new ArrClient((long) interArrivee + Simulateur.getTempsActuel());
        Echeancier.ajouterEvenement(arrClient, Simulateur.getTempsActuel());
        Thread t1 = new Thread((ArrClient)arrClient);
        t1.start();
    }
}
