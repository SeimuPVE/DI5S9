import evenements.Debut;
import evenements.Evenement;
import util.Pair;

import java.util.*;


// Couples évenement/heure triés par heures.
public class Echeancier {
    private List<Pair> evenements;

    public Echeancier() {
        evenements = new ArrayList <> ();
    }

    public void ajouterEvenement(Evenement evenement, Date date) {
        evenements.add(new Pair(evenement, date));
    }

    public void add(Debut debut) {
        // TODO.
    }

    public Evenement get(int i) {
        // TODO.
        return new Evenement() {
            @Override
            public void run() {
                System.out.println("TODO : delete it and return a real event.");
            }
        };
    }
}
