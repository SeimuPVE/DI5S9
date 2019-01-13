package evenements;


import clients.Client;
import clients.Clients;
import util.Simulateur;

public class Fin extends Evenement {
    @Override
    public void run() {

        System.out.println();

        // Génération d'un nouveau fichier à partir des lois empiriques déduites.

        /*for (Client client : Clients.getClients())
            System.out.println(client.getDateArrSystem() + " " + client.getDureeAppel());*/

        System.out.println("Il y a eu " + Simulateur.getN() + " clients au cours de la simulation.");
        System.out.println("La durée moyenne d'attente par client est de : " + Simulateur.getAttGlb() / Simulateur.getN());
        System.out.println("Le nombre moyen de clients dans la file est de : " + Simulateur.getAireClientsDansFile() / Simulateur.getT());
        System.out.println("La proportion d'occupation du téléconseiller est de " + 100 * Simulateur.getAireOccupationConseiller() / Simulateur.getT() + "%");
    }
}
