package util;

import org.apache.commons.math3.distribution.BetaDistribution;
import java.util.concurrent.ThreadLocalRandom;


// Simulation de l'entree (loi exp).
public class LoiSimulateur {
    private static double esperance;


    public static double loi_exp(double lambda) {
        double p;
        double temp;
        double randres;

        if(lambda != 0)
            temp = 1 / lambda;
        else
            return 0;

        while(true) {
            p = ThreadLocalRandom.current().nextDouble();

            if(p < lambda)
                break;
        }

        randres = -temp * Math.log(temp * p);

        return randres;
    }

    public static double loi_beta(double alpha, double beta) {
        esperance = alpha/(alpha+beta);
        BetaDistribution betaDistribution = new BetaDistribution(alpha,beta);

        return betaDistribution.sample();
    }
}
