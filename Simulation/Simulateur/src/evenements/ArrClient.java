package evenements;

import clients.Client;
import clients.Clients;
import util.Parseur;
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
        double interArrivee;
        double now = this.heure;

        if(Simulateur.isFromFile())
            interArrivee = Parseur.heureSuivante();
        else
            interArrivee = LoiSimulateur.loi_exp(Simulateur.lambda_exp_arr_client);

        // Si la simulation n'est pas finie.
        if((Simulateur.isFromFile() && !Parseur.finLecture()) || now < Simulateur.getT()) {
            // Arrivée client.
            Clients.ajouterClient(new Client(now));

            AccFileTelephonique accFileTelephonique = new AccFileTelephonique(now);

            // Créer AccFileTelephonique.
            Echeancier.ajouterEvenement(accFileTelephonique, now);

            if(Simulateur.isFromFile()) {
                ArrClient arrClient = new ArrClient(interArrivee);
                Echeancier.ajouterEvenement(arrClient, interArrivee);
            }
            else {
                ArrClient arrClient = new ArrClient(now + interArrivee);
                Echeancier.ajouterEvenement(arrClient, now + interArrivee);
            }
        }
    }
}
