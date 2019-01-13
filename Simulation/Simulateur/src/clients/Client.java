package clients;


public class Client {
    private double dateArrSystem; // Date d'arrivée dans le système.
    private double dateArrGuichet; // Date d'arrivée au guichet.
    private double dateDepGuichet; // Date de départ du guichet.
    private double dureeAppel; // Durée de l'appel.

    public Client(double dateArrSystem) {
        this.dateArrSystem = dateArrSystem;
    }

    public double getDateArrGuichet() {
        return dateArrGuichet;
    }

    public double getDateDepGuichet() {
        return dateDepGuichet;
    }

    public double getDateArrSystem() {
        return dateArrSystem;
    }

    public double getDureeAppel() { return dureeAppel; }

    public void setDateArrGuichet(double dateArrGuichet) { this.dateArrGuichet = dateArrGuichet; }

    public void setDureeAppel(double dureeAppel) { this.dureeAppel = dureeAppel; }
}
