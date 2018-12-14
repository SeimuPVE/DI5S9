package evenements;


import java.util.concurrent.ThreadLocalRandom;

public class ArrClient extends Evenement implements Runnable {

    public ArrClient() {

    }

    private double loi_exp(double lambda) throws Exception {
        double p;
        double temp;
        if (lambda != 0)
            temp = 1 / lambda;
        else
            throw new Exception("Ne peut pas deviser par 0");
        double randres;
        while(true)
        {
            p = ThreadLocalRandom.current().nextDouble();
            if (p < lambda)
                break;
        }
        randres = -temp * Math.log(temp * p);
        return randres;
    }

    @Override
    public void run() {

    }
}
