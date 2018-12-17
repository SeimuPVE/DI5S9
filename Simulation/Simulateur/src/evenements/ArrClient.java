package evenements;

import clients.Client;
import clients.Clients;
import util.Echeancier;
import util.LoiSimulateur;
import util.Simulateur;


public class ArrClient extends Evenement implements Runnable {
    private long heure;

    public ArrClient(long heure) {
        this.heure = heure;
    }


    @Override
    public void run() {
        // inter arrivee
        long interArrivee = (long) LoiSimulateur.loi_exp(0.4);

        // Si la simulation n'est pas fini
        if (Simulateur.getTempsActuel() < Simulateur.getT()) {
            // arrivee client
            Clients.ajouterClient(new Client(Simulateur.getTempsActuel()));


            AccFileTelephonique accFileTelephonique = new AccFileTelephonique();
            // creer AccFileTelephonique
            Echeancier.ajouterEvenement(accFileTelephonique, Simulateur.getTempsActuel());

            ArrClient arrClient = new ArrClient(Simulateur.getTempsActuel() + interArrivee);
            Echeancier.ajouterEvenement(arrClient, Simulateur.getTempsActuel() + interArrivee);

            arrClient.run();
            accFileTelephonique.run();
        }


    }
}
