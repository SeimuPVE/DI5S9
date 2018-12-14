package evenements;


import clients.Client;
import clients.Clients;
import util.Echeancier;
import util.LoiSimulateur;
import util.Simulateur;


public class ArrClient extends Evenement implements Runnable {

    public ArrClient() {

    }



    @Override
    public void run() {
        // Si la simulation n'est pas fini
        while(Simulateur.getTempsActuel()!=Simulateur.getT()){
            // arrivee client
            Clients.ajouterClient(new Client(Simulateur.getTempsActuel()));

            // inter arrivee
            long interArrivee = (long)LoiSimulateur.loi_exp(0.4);

            // creer AccFileTelephonique
            Echeancier.ajouterEvenement(new AccFileTelephonique(), Simulateur.getTempsActuel());

        }
    }
}
