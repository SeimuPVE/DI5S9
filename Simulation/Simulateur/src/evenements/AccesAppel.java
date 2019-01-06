package evenements;

import clients.Clients;
import util.Parseur;
import util.Echeancier;
import util.LoiSimulateur;
import util.Simulateur;


public class AccesAppel extends Evenement {
    private double heure;


    public AccesAppel(double heure) {
        this.heure = heure;
    }

    @Override
    public void run() {
        Simulateur.setQ(Simulateur.getQ() - 1);
        Simulateur.setB(true);

        Clients.getClientAt(Simulateur.getN()).setDateArrGuichet(this.heure);

        //if (Simulateur.getTempsActuel() - Clients.getClientAt(Simulateur.getN()).getDateArrSystem() > Simulateur.getTempsMax())
        //    Simulateur.setTempsMax(Simulateur.getTempsActuel() - Clients.getClientAt(Simulateur.getN()).getDateArrSystem());

        Simulateur.setAttGlb(Simulateur.getAttGlb() + Clients.getClientAt(Simulateur.getN()).getDateArrGuichet() - Clients.getClientAt(Simulateur.getN()).getDateArrSystem());
        Simulateur.setN(Simulateur.getN() + 1);

        double tempsService;
        if(Simulateur.isFromFile())
            tempsService = Parseur.dureeSuivante();
        else if(Simulateur.getChoix() == 1){
            tempsService = 5.157;
        }
        else if(Simulateur.getChoix() == 3){
            tempsService = 5.157;
        }
        else{
            tempsService = LoiSimulateur.loi_beta(Simulateur.alpha_acces_appel,Simulateur.beta_acces_appel);
        }

        Simulateur.setAireOccupationConseiller(Simulateur.getAireOccupationConseiller() + tempsService);

        Evenement finAppel = new FinAppel(this.heure + tempsService);
        Echeancier.ajouterEvenement(finAppel, this.heure + tempsService);
    }
}
