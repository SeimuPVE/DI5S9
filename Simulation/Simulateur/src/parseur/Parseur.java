package parseur;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Parseur {
    private static int compteurArr;
    private static int compteurDuree;
    private static List<Double> dateArrAppels;
    private static List<Double> dureeAppels;

    public Parseur(String fileName) throws IOException {
        compteurArr = 0;
        compteurDuree = 0;

        dateArrAppels = new ArrayList <> ();
        dureeAppels = new ArrayList <> ();

        FileInputStream stream = new FileInputStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        String line;

        while ((line = reader.readLine()) != null) {
            String [] donnees = line.split(" ");

            dateArrAppels.add(Double.parseDouble(donnees[0]));
            dureeAppels.add(Double.parseDouble(donnees[1]));
        }

        reader.close();
    }

    public List<Double> getDateArrAppels() {
        return dateArrAppels;
    }

    public List<Double> getDureeAppels() {
        return dureeAppels;
    }

    public static Double heureSuivante() {
        Double result = dateArrAppels.get(compteurArr);

        if(compteurArr > 0)
            result -= dateArrAppels.get(compteurArr - 1);

        compteurArr++;
        return result;
    }

    public static Double dureeSuivante() {
        Double result = dureeAppels.get(compteurDuree);
        compteurDuree++;
        return result;
    }
}
