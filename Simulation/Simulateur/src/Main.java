/*
 * Echeancier : couple événements/heures trié par heures
 *
 * Evenement : classe abstraite
 * Chaque événement a sa classe
 * ArrClient parallélisé
 *
 * Chaque événément lance son événement suivant
 */
public class Main {
    public static void main(String[] args) {
        Simulateur simulateur = new Simulateur(500);
    }
}
