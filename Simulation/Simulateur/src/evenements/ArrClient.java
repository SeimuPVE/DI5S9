package evenements;

import clients.Client;
import clients.Clients;
import util.Echeancier;
import util.LoiSimulateur;
import util.Simulateur;


public class ArrClient extends Evenement{
    private long heure;

    public ArrClient(long heure) {
        this.heure = heure;
    }


    @Override
    public void run() {
        // inter arrivee
        long interArrivee = (long) LoiSimulateur.loi_exp(0.4);
//        System.out.println("inter arrive:"+ interArrivee);
        // Si la simulation n'est pas fini
        long now = this.heure;
        if (now < Simulateur.getT()) {
            // arrivee client
            Clients.ajouterClient(new Client(now));

            AccFileTelephonique accFileTelephonique = new AccFileTelephonique(now);
            // creer AccFileTelephonique
            Echeancier.ajouterEvenement(accFileTelephonique, now);

            ArrClient arrClient = new ArrClient(now + interArrivee);
            Echeancier.ajouterEvenement(arrClient, now + interArrivee);

//            arrClient.run();
//            Thread thread = new Thread(arrClient);
//            accFileTelephonique.run();
        }


    }
}
