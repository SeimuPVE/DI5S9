package clients;


public class Client {
    private double dateArrSystem; // Date d'arrivée dans le système.
    private float dateArrGuichet; // Date d'arrivée au guichet.
    private float dateDepGuichet; // Date de départ du guichet.

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
}
