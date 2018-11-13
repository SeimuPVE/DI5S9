package fr.polytechtours.javaperformance.tp.tp4;

/**
 * Cette exercice permet de multiplier une matrice de int en entrée avec la matrice MATRIX_A et de retourner le résultat.
 */
public class Exercice1 {

    private static final Float[][] MATRIX_A = {
            {1/42f,1/42f,2/42f,2/42f,2/42f,1/42f,1/42f},
            {1/42f,2/42f,3/42f,4/42f,3/42f,2/42f,1/42f},
            {2/42f,3/42f,4/42f,5/42f,4/42f,3/42f,2/42f},
            {2/42f,4/42f,5/42f,8/42f,5/42f,4/42f,2/42f},
            {2/42f,3/42f,4/42f,5/42f,4/42f,3/42f,2/42f},
            {1/42f,2/42f,3/42f,4/42f,3/42f,2/42f,1/42f},
            {1/42f,1/42f,2/42f,2/42f,2/42f,1/42f,1/42f}
    };

    /**
     * Utilise la symétrie de la matrice.
     * On réduit les tours dans la boucle mais pas les calculs donc on perd 10% de performance.
     * En fait on fait 2x moins de tour de boucle mais avec 2x plus de calculs dans le boucles.
     * Et du coup on utilise 2x plus de variable aussi donc on gagne rien.
     */
    public static float[][] multiply_v04(final int[][] matrix) {
        final float[][] result = new float[7][7];
        float currentValue;
        float oppositeCurrentValue;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7 - i; j++) {
                currentValue = 0.0f;
                oppositeCurrentValue = 0.0f;

                for (int k = 0; k < 7; k++) {
                    currentValue = currentValue + matrix[i][k] * MATRIX_A[k][j];
                    oppositeCurrentValue = oppositeCurrentValue + matrix[7-1-i][k] * MATRIX_A[k][7-1-j];
                }

                result[i][j] = currentValue;
                result[7-1-i][7-1-j] = oppositeCurrentValue;
            }
        }

        return result;
    }

    /**
     * On enlève le final sur le résultat.
     * C'est la version v03 qu'on va garder car c'est la plus performante qu'on ait réussi à obtenir.
     */
    public static float[][] multiply(final int[][] matrix) {
        final float[][] result = new float[7][7];
        float currentValue;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                currentValue = 0.0f;

                for (int k = 0; k < 7; k++) {
                    currentValue = currentValue + matrix[i][k] * MATRIX_A[k][j];
                }

                result[i][j] = currentValue;
            }
        }

        return result;
    }

    /**
     * Change les appels Float et Integer ainsi que l'incrémentation dans les boucles. La déclaration du current value est sortie de la boucle.
     */
    public static float[][] multiply_v02(final int[][] matrix) {
        final float[][] result = new float[7][7];
        float currentValue;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                currentValue = 0.0f;

                for (int k = 0; k < 7; k++) {
                    currentValue = currentValue + matrix[i][k] * MATRIX_A[k][j];
                }

                result[i][j] = currentValue;
            }
        }

        return result;
    }

    /**
     * Version fournie dans le TP.
     */
    public static float[][] multiply_v01(final int[][] matrix) {
        final float[][] result = new float[7][7];

        for (Integer i = 0; i < 7; i = i + 1) {
            for (Integer j = 0; j < 7; j = j + 1) {
                Float currentValue = 0F;

                for (Integer k = 0; k < 7; k = k + 1) {
                    currentValue = currentValue + matrix[i][k] * MATRIX_A[k][j];
                }

                result[i][j] = currentValue;
            }
        }

        return result;
    }
}
