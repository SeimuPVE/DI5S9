import util.Simulateur;


public class Main {
    public static void main(String[] args) {
        //Simulateur simulateur = new Simulateur(10);
        Simulateur simulateur = new Simulateur("src/ressources/DataAppels.txt");
        simulateur.run();
    }
}
