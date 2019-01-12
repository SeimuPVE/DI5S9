import util.Simulateur;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Simulateur simulateur;
        Scanner scanner = new Scanner(System.in);
        boolean quitter = false;
        int mode;

        int temps_simulation;
        double temps_service;

        while(!quitter) {
            System.out.println("Simulation Mode:\n 1. Simulation avec des inter-arrivées et durées de traitement constantes; " +
                    "\n 2. Simulation avec des inter-arrivées et durées de traitement constantes présentes dans le ficher;" +
                    "\n 3. Simulation avec des inter-arrivées sont de la loi exponentielle et durées de traitement constantes (= moyenne);" +
                    "\n 4. Simulation avec des inter-arrivées sont de la loi exponentielle et les durées de traitement constantes sont de la loi beta." +
                    "\n 5. Quitter.");

            System.out.println("\n" + "------ Choissez un mode ------");
            mode = scanner.nextInt();

            switch(mode) {
                case 1:
                    System.out.print("Temps de simulation (en secondes) : ");
                    temps_simulation = scanner.nextInt();
                    System.out.print("Inter-arrivées : ");
                    double inter_arrivee = scanner.nextDouble();
                    System.out.print("Temps de service : ");
                    temps_service = scanner.nextDouble();

                    simulateur = new Simulateur(1, temps_simulation, inter_arrivee, temps_service);
                    simulateur.run();
                    break;

                case 2:
                    System.out.print("Chemin du fichier : ");
                    simulateur = new Simulateur(2, "DataAppels.txt");
                    simulateur.run();
                    break;

                case 3:
                    System.out.print("Temps de simulation (en secondes) : ");
                    temps_simulation = scanner.nextInt();
                    System.out.print("Lamdba pour la loi exponentielle de l'arrivée des clients : ");
                    double lamdba_exp_arr_client = scanner.nextDouble();
                    System.out.print("Temps de service : ");
                    temps_service = scanner.nextDouble();

                    simulateur = new Simulateur(3, temps_simulation, lamdba_exp_arr_client, temps_service);
                    simulateur.run();
                    break;

                case 4:
                    System.out.print("Temps de simulation (en secondes) : ");
                    temps_simulation = scanner.nextInt();
                    System.out.print("Lamdba pour la loi exponentielle de l'arrivée des clients : ");
                    double lambda_exp_arr_client = scanner.nextDouble();
                    System.out.print("Alpha pour l'accès aux appels : ");
                    double alpha_acces_appel = scanner.nextDouble();
                    System.out.print("Beta pour l'accès aux appels : ");
                    double beta_acces_appel = scanner.nextDouble();

                    simulateur = new Simulateur(4, temps_simulation, lambda_exp_arr_client, alpha_acces_appel, beta_acces_appel);
                    simulateur.run();
                    break;

                case 5:
                    quitter = true;
                    break;
            }

            System.out.println();
        }
    }
}
