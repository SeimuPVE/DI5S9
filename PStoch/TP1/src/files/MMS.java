package files;

import static java.lang.Math.pow;


public class MMS extends queueTemplate{
    private int s;

    public MMS(double lambda, double mu, int s) throws Exception {
        super(lambda, mu);
        this.s = s;

        calculRho();
        if(rho > 1) throw new Exception("Rho > 1, système surchargé.");

        calculAll();
    }

    public static int factorielle(int n) {
        int produit = 1;
        int i;

        for(i = 1; i <= n; i++)
            produit *= i;

        return produit;
    }

    @Override
    void calculAll() {

    }

    @Override
    void calculRho() {
        rho = lambda/(s*mu);
    }

    @Override
    void calculQ0() {
        double som = 0;

        for(int j =0; j<s; j++)
            som = pow((rho*s),j)/factorielle(j);

        q0 = som + pow(rho*s, s)/factorielle(s)*(1-rho);
        q0 = 1/q0;
    }

    @Override
    void calculL() {
        L = Lq + (lambda/mu);
    }

    @Override
    void calculLq() {
        Lq = ((q0 * pow(s, s) * pow(rho, s + 1)) / factorielle(s)) * (1 / pow(1 - rho, 2));
    }

    @Override
    void calculW() {
        W = Wq + (1/mu);
    }

    @Override
    void calculWq() {
        Wq = Lq/lambda;
    }


    @Override
    double getQ(int j) throws Exception {
        if(j < 0)
            throw new Exception("L'argument j doit être plus grand 0.");
        else if(j < s)
            return (pow(rho*s, j) / factorielle(j)) * q0;
        else
            return ((pow(s, s) * pow(rho, j)) / factorielle(s)) * q0;
    }
}
