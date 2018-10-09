package fr.polytechtours.javaperformance.tp2;

public class BouclesNazes {
    public static void stupidFor(int stop) {
        int i, stupid_variable = 0;

        for(i = 0; i < stop; i++)
            stupid_variable += 10 * i;
    }

    public static void stupidWhile(int stop) {
        int i = 0, stupid_variable = 0;

        while(i < stop) {
            stupid_variable += 10 * i;
            i++;
        }
    }
}
