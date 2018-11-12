package files;


import static java.lang.Math.pow;

public class MM1K extends queueTemplate {
    private int k;

    protected MM1K(double lambda, double mu, int k) {
        super(lambda, mu);
        this.k = k;
        calculAll();
    }

    @Override
    void calculAll() {
        calculRho();
        calculQ0();
        calculL();
        calculLq();
        calculW();
        calculWq();
    }

    @Override
    void calculRho() {
        rho = lambda/mu;
    }

    @Override
    void calculQ0() {
        q0 = 1 - rho;
    }

    @Override
    void calculL() {
        if(rho == 1)
            L = k/2;
        else {
            double top = rho * (1 - (k+1) * pow(rho, k) + k*pow(rho, k+1));
            double down = (1-rho) * (1-pow(rho, k+1));
            L = top / down;
        }
    }

    @Override
    void calculLq() {
        Lq = L - (1 - q0);
    }

    @Override
    void calculW() {
        W = 1 / (mu / lambda);
    }

    @Override
    void calculWq() {
        Wq = lambda / (mu * (mu - lambda));
    }

    @Override
    double getQ(int j) {
        if(rho == 1)
            return 1 / (k-1);
        else
            return ((1-rho) * pow(rho, j)) / ((1 - pow(rho, k+1)));
    }
}
