import util.Simulateur;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //Simulateur simulateur = new Simulateur(10);


        System.out.println("Simalation Mode:\n 1. Simulation avec des inter-arrivées et durées de traitement constantes; " +
                "\n 2. Simulation avec des inter-arrivées et durées de traitement constantes présentes dans le ficher;" +
                "\n 3. Simulation avec des inter-arrivées sont de la loi exponentielle et durées de traitement constantes (= moyenne);" +
                "\n 4. Simulation avec des inter-arrivées sont de la loi exponentielle et les durées de traitement constantes sont de la loi beta.");

        Scanner scanner = new Scanner(System.in);

        while (true){

            System.out.println("\n" + "------ Choissez un mode ------");

            int mode = scanner.nextInt();
            switch (mode){
                case 1:

                    break;
                case 2:
                    Simulateur simulateur = new Simulateur("Simulateur/src/ressources/DataAppels.txt");
                    simulateur.run();
                    break;
                case 3:

                    break;

                case 4:
                    break;

            }
        }
    }
}
