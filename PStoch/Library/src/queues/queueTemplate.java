package queues;


abstract class queueTemplate {
    // Attributes.
    protected double lambda;
    protected double mu;

    protected double rho;
    protected double q0;
    protected double L;
    protected double Lq;
    protected double W;
    protected double Wq;

    // Methods.
    protected queueTemplate(double lambda, double mu) {
        this.lambda = lambda;
        this.mu = mu;
    }

    abstract void calculAll();
    abstract void calculRho();
    abstract void calculQ0();
    abstract void calculL();
    abstract void calculLq();
    abstract void calculW();
    abstract void calculWq();

    protected double getLambda() {
        return lambda;
    }

    protected double getMu() {
        return mu;
    }

    protected double getRho() {
        return rho;
    }

    protected double getQ0() {
        return q0;
    }

    protected double getL() {
        return L;
    }

    protected double getLq() {
        return Lq;
    }

    protected double getW() {
        return W;
    }

    protected double getWq() {
        return Wq;
    }

    abstract double getQ(int j) throws Exception;
}
