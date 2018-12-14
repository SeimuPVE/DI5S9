package clients;

public class Client
{
    private float dateArrSystem; // Date d'arrivée dans le système.
    private float dateArrGuichet; // Date d'arrivée au guichet.
    private float dateDepGuichet; // Date de départ du guichet.

    public Client(float dateArrSystem) {
        this.dateArrSystem = dateArrSystem;
    }

    public float getDateArrGuichet() {
        return dateArrGuichet;
    }

    public float getDateDepGuichet() {
        return dateDepGuichet;
    }

    public float getDateArrSystem() {
        return dateArrSystem;
    }
}
