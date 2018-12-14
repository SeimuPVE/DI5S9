package evenements;


public abstract class Evenement {
    public Evenement() {
        System.out.println(getClass().getName());
    }

    public abstract void run();
}
