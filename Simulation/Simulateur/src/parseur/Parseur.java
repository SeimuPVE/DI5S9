package parseur;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Parseur {
    List <Float> dateArrAppels;
    List <Float> dureeAppels;

    public Parseur(String fileName) throws IOException {
        dateArrAppels = new ArrayList <> ();
        dureeAppels = new ArrayList <> ();

        FileInputStream stream = new FileInputStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        String line;

        while ((line = reader.readLine()) != null) {
            String [] donnees = line.split(" ");

            dateArrAppels.add(Float.parseFloat(donnees[0]));
            dureeAppels.add(Float.parseFloat(donnees[1]));
        }

        reader.close();
    }

    public List <Float> getDateArrAppels() {
        return dateArrAppels;
    }

    public List <Float> getDureeAppels() {
        return dureeAppels;
    }
}
