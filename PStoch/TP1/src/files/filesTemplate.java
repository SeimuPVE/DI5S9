package files;

import java.util.ArrayList;


abstract class filesTemplate {
    // Attributes.
    protected int alpha;
    protected int nu;

    protected float rho;
    protected float q0;
    protected float L;
    protected float Lq;
    protected float w;
    protected float wq;
    protected ArrayList<Float> q = new ArrayList<>();

    // Methods.
    protected filesTemplate(int alpha, int nu) {
        this.alpha = alpha;
        this.nu = nu;
    }

    abstract void calculAll();
    abstract float calculRho();
    abstract float calculQ0();
    abstract float calculL();
    abstract float calculLq();
    abstract float calculW();
    abstract float calculWq();
    abstract ArrayList<Float> calculQ(int j);

    protected int getAlpha() {
        return alpha;
    }

    protected int getNu() {
        return nu;
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
        return w;
    }

    protected float getWq() {
        return wq;
    }

    protected ArrayList<Float> getQ() {
        return q;
    }
}
