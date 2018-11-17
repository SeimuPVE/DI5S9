package fr.polytechtours.javaperformance.tp.tp4;

import java.lang.reflect.InvocationTargetException;

/**
 * L'objectif de cet exercice est de retourner la valeur du nom de l'objet Guy passé en paramètre.
 */
public class Exercice5 {

    public static final class Guy {
        private final String name;

        public Guy(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * Utilisation du type de paramètre.
     */
    public static String getName(final Guy guy) {
        return guy.getName();
    }

    /**
     * Méthode fournie dans le TP.
     */
    public static String getName_v01(final Guy guy) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (String) guy.getClass().getMethod("getName").invoke(guy);
    }
}
