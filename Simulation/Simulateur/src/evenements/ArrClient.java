package evenements;

import clients.Client;
import clients.Clients;
import util.Echeancier;
import util.LoiSimulateur;
import util.Simulateur;


public class ArrClient extends Evenement implements Runnable {
    @Override
    public void run() {
        // Si la simulation n'est pas finie.
        while (Simulateur.getTempsActuel() != Simulateur.getT()) {
            // Arrivee client.
            Clients.ajouterClient(new Client(Simulateur.getTempsActuel()));

            // Inter arrivee.
            long interArrivee = (long) LoiSimulateur.loi_exp(0.4);

            // Creer AccFileTelephonique.
            Echeancier.ajouterEvenement(new AccFileTelephonique(), Simulateur.getTempsActuel());
        }
    }
}
