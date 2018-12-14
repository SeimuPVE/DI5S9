package util;

import evenements.Evenement;

import java.util.Date;


public class Pair
{
    private Evenement evenement;
    private float date;


    public Pair(Evenement evenement, float date)
    {
        this.evenement = evenement;
        this.date = date;
    }

    public Evenement getEvenement()
    {
        return evenement;
    }

    public float getDate()
    {
        return date;
    }
}
