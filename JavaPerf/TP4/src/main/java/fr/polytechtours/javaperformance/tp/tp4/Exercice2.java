package fr.polytechtours.javaperformance.tp.tp4;

/**
 * Cette exercice met en place un algorithme permettant de calculer le 43eme facteur de la suite de Fibonacci.
 */
public class Exercice2 {
    /**
     * Version optimisée, sans récursivité.
     */
    public static int fibonacci(final Integer i) {
        int j, nA = 0, nB = 1, result = 0;

        if(i < 0)
            throw new IllegalArgumentException("Invalid input value");

        if(i < 3)
            return i;

        for(j = 0; j < i; j++) {
            result = nA + nB;
            nA = nB;
            nB = result;
        }

        return result;
    }

    /**
     * Version fournie dans le TP.
     */
    public static int fibonacci_v01(final Integer i) {
        if(i < 0) {
            throw new IllegalArgumentException("Invalid input value");
        }

        return (i < 3) ? i : fibonacci(i - 1) + fibonacci(i - 2);
    }
}
