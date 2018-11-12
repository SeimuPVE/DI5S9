package files;


// TODO : if(lambda/mu < 1) -> blocage.
public class MM1 extends filesTemplate {
    public MM1(int lambda, int mu) {
        super(lambda, mu);
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
        rho = lambda/ mu;
    }

    @Override
    void calculQ0() {
        q0 = 1 - rho;
    }

    @Override
    void calculL() {
        L = lambda/(mu -lambda);
    }

    @Override
    void calculLq() {
        Lq = (lambda*lambda) / (mu * (mu -lambda));
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
    float getQ(int j) {
        float rhoPuissance = rho;
        int i;

        for(i = 1; i < j; i++)
            rhoPuissance *= rho;

        return rhoPuissance * (1-rho);
    }
}
