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
                    Simulateur simulateur = new Simulateur(30);
                    Simulateur.setChoix(1);
                    simulateur.run();
                    break;
                case 2:
                    Simulateur simulateur2 = new Simulateur("Simulateur/src/ressources/DataAppels.txt");
                    Simulateur.setChoix(2);
                    simulateur2.run();
                    break;
                case 3:
                    Simulateur simulateur3 = new Simulateur(30);
                    Simulateur.setChoix(3);
                    simulateur3.run();
                    break;

                case 4:
                    Simulateur simulateur4 = new Simulateur(30);
                    Simulateur.setChoix(4);
                    simulateur4.run();
                    break;

            }
        }
    }
}
