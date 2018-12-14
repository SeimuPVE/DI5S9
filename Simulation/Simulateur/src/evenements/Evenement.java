package evenements;


/**
 * Evenement : classe abstraite
 * Chaque événement a sa classe
 * ArrClient parallélisé
 *
 * Chaque événément lance son événement suivant
 */
public abstract class Evenement {
    public abstract void run();
}
