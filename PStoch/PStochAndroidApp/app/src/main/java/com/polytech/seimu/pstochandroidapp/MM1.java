package com.polytech.seimu.pstochandroidapp;


public class MM1 extends queueTemplate {
    public MM1(double lambda, double mu) throws Exception {
        super(lambda, mu);

        if(lambda/mu >= 1) throw new Exception("The parameters cause a block.");

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
        W = 1 / (mu - lambda);
    }

    @Override
    void calculWq() {
        Wq = lambda / (mu * (mu - lambda));
    }

    @Override
    double getQ(int j) {
        double rhoPuissance = rho;
        int i;

        for(i = 1; i < j; i++)
            rhoPuissance *= rho;

        return rhoPuissance * (1-rho);
    }
}
