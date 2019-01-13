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

        double attente = Clients.getClientAt(Simulateur.getN()).getDateArrGuichet() - Clients.getClientAt(Simulateur.getN()).getDateArrSystem();

        if (attente < Simulateur.min && attente != 0)
            Simulateur.min = attente;

        if (attente > Simulateur.max)
            Simulateur.max = attente;




        Simulateur.setAttGlb(Simulateur.getAttGlb() + Clients.getClientAt(Simulateur.getN()).getDateArrGuichet() - Clients.getClientAt(Simulateur.getN()).getDateArrSystem());

        double tempsService = 0;

        if(Simulateur.isFromFile())
            tempsService = Parseur.dureeSuivante();
        else if(Simulateur.getChoix() == 1)
            tempsService = Simulateur.temps_service;
        else if(Simulateur.getChoix() == 3)
            tempsService = Simulateur.temps_service;
        else if (Simulateur.getChoix() == 4)
            tempsService = LoiSimulateur.loi_beta(Simulateur.alpha_acces_appel, Simulateur.beta_acces_appel);

        Simulateur.setAireOccupationConseiller(Simulateur.getAireOccupationConseiller() + tempsService);

        Clients.getClientAt(Simulateur.getN()).setDureeAppel(tempsService);
        Simulateur.setN(Simulateur.getN() + 1);

        Evenement finAppel = new FinAppel(this.heure + tempsService);
        Echeancier.ajouterEvenement(finAppel, this.heure + tempsService);
    }
}
