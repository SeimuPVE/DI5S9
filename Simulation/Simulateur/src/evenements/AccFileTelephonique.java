package evenements;


import util.Echeancier;
import util.Simulateur;

public class AccFileTelephonique extends Evenement {
    private long heure;

    public AccFileTelephonique(long heure) {
        this.heure = heure;
    }

    @Override
    public void run() {
        Simulateur.setQ(Simulateur.getQ() + 1);


        if (!Simulateur.isB()) {
            Evenement accesAppel = new AccesAppel(this.heure);
            Echeancier.ajouterEvenement(accesAppel, this.heure);

        }


    }
}
