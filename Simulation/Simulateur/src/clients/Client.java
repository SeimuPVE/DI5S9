package clients;

public class Client
{
    private static float dateArrGuichet; // Date d'arrivée au guichet.
    private static float dateDepGuichet; // Date de départ du guichet.

    public Client(float dateArrGuichet, float dateDepGuichet)
    {
        this.dateArrGuichet = dateArrGuichet;
        this.dateDepGuichet = dateDepGuichet;
    }

    public static float getDateArrGuichet()
    {
        return dateArrGuichet;
    }

    public static  float getDateDepGuichet()
    {
        return dateDepGuichet;
    }
}
