package util;

import evenements.Evenement;


public class Pair implements Comparable<Pair> {
    private Evenement evenement;
    private double date;


    public Pair(Evenement evenement, double date) {
        this.evenement = evenement;
        this.date = date;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public double getDate() {
        return date;
    }

    @Override
    public int compareTo(Pair p) {
        if(this.date > p.date)
            return 1;
        else if (this.date == p.date)
            return 0;
        else
            return -1;
    }
}
