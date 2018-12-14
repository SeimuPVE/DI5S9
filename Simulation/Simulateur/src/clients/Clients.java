package clients;

import java.util.ArrayList;
import java.util.List;


public class Clients
{
    private static List <Client> clients;

    public Clients()
    {
        clients = new ArrayList <> ();
    }

    public static void ajouterClient(Client client)
    {
        clients.add(client);
    }

    public static List <Client> getClients()
    {
        return clients;
    }

    public static Client getClientAt(int i)
    {
        return clients.get(i);
    }
}
