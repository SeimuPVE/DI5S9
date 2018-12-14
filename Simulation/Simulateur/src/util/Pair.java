package util;

import evenements.Evenement;

import java.util.Date;


public class Pair
{
    private Evenement evenement;
    private Date date;


    public Pair(Evenement evenement, Date date)
    {
        this.evenement = evenement;
        this.date = date;
    }

    public Evenement getEvenement()
    {
        return evenement;
    }

    public Date getDate()
    {
        return date;
    }
}
