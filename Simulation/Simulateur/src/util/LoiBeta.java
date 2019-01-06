package util;
import org.apache.commons.math3.distribution.BetaDistribution;
//import org.apache.commons.math3.special.Gamma;

public class LoiBeta {
    // Simulation de l'entree (loi exp).

    private static double esperance;
    public static double loi_beta(double alpha, double beta) {

        esperance = alpha/(alpha+beta);

        BetaDistribution betaDistribution = new BetaDistribution(alpha,beta);

        return betaDistribution.sample();
    }
}
