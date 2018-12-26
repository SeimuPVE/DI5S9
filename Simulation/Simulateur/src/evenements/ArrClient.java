package evenements;

import clients.Client;
import clients.Clients;
import parseur.Parseur;
import util.Echeancier;
import util.LoiSimulateur;
import util.Simulateur;


public class ArrClient extends Evenement{
    private double heure;

    public ArrClient(double heure) {
        this.heure = heure;
    }

    @Override
    public void run() {
        // Inter arrivées.
//        double interArrivee = (long) LoiSimulateur.loi_exp(0.4); // TODO.
        double interArrivee = Parseur.heureSuivante();
        double now = this.heure;

        // Si la simulation n'est pas finie.
        if (now < Simulateur.getT()) {
            // Arrivée client.
            Clients.ajouterClient(new Client(now));

            AccFileTelephonique accFileTelephonique = new AccFileTelephonique(now);

            // Créer AccFileTelephonique.
            Echeancier.ajouterEvenement(accFileTelephonique, now);

            ArrClient arrClient = new ArrClient(now + interArrivee);
            Echeancier.ajouterEvenement(arrClient, now + interArrivee);
        }
    }
}
