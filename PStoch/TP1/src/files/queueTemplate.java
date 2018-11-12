package files;

import java.util.ArrayList;


abstract class queueTemplate {
    // Attributes.
    protected float lambda;
    protected float mu;

    protected float rho;
    protected float q0;
    protected float L;
    protected float Lq;
    protected float W;
    protected float Wq;
    protected ArrayList<Float> q = new ArrayList<>();

    // Methods.
    protected queueTemplate(float lambda, float mu) {
        this.lambda = lambda;
        this.mu = mu;
        calculAll();
    }

    abstract void calculAll();
    abstract void calculRho();
    abstract void calculQ0();
    abstract void calculL();
    abstract void calculLq();
    abstract void calculW();
    abstract void calculWq();

    protected float getLambda() {
        return lambda;
    }

    protected float getMu() {
        return mu;
    }

    protected float getRho() {
        return rho;
    }

    protected float getQ0() {
        return q0;
    }

    protected float getL() {
        return L;
    }

    protected float getLq() {
        return Lq;
    }

    protected float getW() {
        return W;
    }

    protected float getWq() {
        return Wq;
    }

    abstract float getQ(int j);
}
