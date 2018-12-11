import evenements.Evenement;
import util.Pair;

import java.util.*;


public class Echeancier
{
    private List <Pair> evenements;


    public Echeancier()
    {
        evenements = new ArrayList <> ();
    }

    public void ajouterEvenement(Evenement evenement, Date date)
    {
        evenements.add(new Pair(evenement, date));
    }
}
