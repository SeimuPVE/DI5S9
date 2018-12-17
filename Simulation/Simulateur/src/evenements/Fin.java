package evenements;


import util.Simulateur;

public class Fin extends Evenement {
    @Override
    public void run() {
        // PAGRANULEUX.
        System.out.println("Temps d’attente maximum :"+ Simulateur.getTempsActuel());
        System.out.println("Temps d’attente moyen :" + Simulateur.getAttGlb() / Simulateur.getN());
    }
}
