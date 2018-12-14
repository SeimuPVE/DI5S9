package util;

import java.util.concurrent.ThreadLocalRandom;

public class LoiSimulateur {
    /**
     * Simulation de l'entree (loi exp)
     * @param lambda
     * @return
     */
    public static double loi_exp(double lambda) {
        double p;
        double temp;
        if (lambda != 0)
            temp = 1 / lambda;
        else
            return 0;
        double randres;
        while(true)
        {
            p = ThreadLocalRandom.current().nextDouble();
            if (p < lambda)
                break;
        }
        randres = -temp * Math.log(temp * p);
        return randres;
    }
}
