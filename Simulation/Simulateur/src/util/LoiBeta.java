package util;
import org.apache.commons.math3.distribution.BetaDistribution;


// À abandonner
// Simulation de l'entree (loi exp).
public class LoiBeta {
    private static double esperance;


    public static double loi_beta(double alpha, double beta) {
        esperance = alpha/(alpha+beta);
        BetaDistribution betaDistribution = new BetaDistribution(alpha,beta);

        return betaDistribution.sample();
    }
}
