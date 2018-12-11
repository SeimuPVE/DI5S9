import java.util.ArrayList;


public class Echeancier
{
    private List <Evenement> evenements;


    public Echeancier()
    {
        evenements = new ArrayList <Evenement> ();
    }

    public void addEvenement(Evenement evenement)
    {
        evenements.add(evenement);
    }

    public List <Evenement> getEvenements()
    {
        return evenements;
    }
}
