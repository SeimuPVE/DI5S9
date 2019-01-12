package util;

import java.io.*;
import java.util.ArrayList;


public class Parseur {
    private static int compteurArr;
    private static int compteurDuree;
    private static ArrayList<Double> dateArrAppels;
    private static ArrayList<Double> dureeAppels;


    public Parseur(String fileName) throws IOException {
        compteurArr = 0;
        compteurDuree = 0;

        dateArrAppels = new ArrayList <> ();
        dureeAppels = new ArrayList <> ();

        System.out.println("GO !");
        FileInputStream stream = new FileInputStream(getClass().getClassLoader().getResource(fileName).getFile());
        System.out.println("GO !");
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        String line;

        while ((line = reader.readLine()) != null) {
            dateArrAppels.add(Double.parseDouble(line.split(" ")[0]));
            dureeAppels.add(Double.parseDouble(line.split(" ")[1]));
        }

        reader.close();
    }

    public ArrayList<Double> getDateArrAppels() {
        return dateArrAppels;
    }

    public ArrayList<Double> getDureeAppels() {
        return dureeAppels;
    }

    public static Double heureSuivante() {
        Double result = dateArrAppels.get(compteurArr);
        compteurArr++;
        return result;
    }

    public static Double dureeSuivante() {
        Double result = dureeAppels.get(compteurDuree);
        compteurDuree++;
        return result;
    }

    public static boolean finLecture() {
        return compteurArr >= dateArrAppels.size();
    }
}
