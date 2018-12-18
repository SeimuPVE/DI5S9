package util;

import evenements.Evenement;
import java.util.*;


// Couples évenement/heure triés par heures.
public class Echeancier {
    private static List<Pair> evenements = new ArrayList <> ();

    public static void ajouterEvenement(Evenement evenement, double date) {
        evenements.add(new Pair(evenement, date));
    }

    public static Evenement get(int i) {
        return evenements.get(i).getEvenement();
    }

    public static List<Pair> getEvenements() {
        return evenements;
    }
}
