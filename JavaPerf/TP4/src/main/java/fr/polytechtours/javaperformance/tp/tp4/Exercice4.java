package fr.polytechtours.javaperformance.tp.tp4;

import java.util.LinkedList;
import java.util.List;

/**
 * L'objectif de cet exercice est de condenser un nombre indéfini de tableaux de bytes dans un seul et unique tableau. Les tableaux seront concaténés dans l'ordre d'entrée.
 */
public class Exercice4 {

    /**
     * Suppression du passage par une List.
     */
    public static byte[] exercice4(byte[]... bytes) {
        byte[] result;
        int listSize = 0;
        int i = 0;

        for(byte[] byteArray : bytes)
            for(byte currentByte : byteArray)
                listSize++;

        result = new byte[listSize];

        for(byte[] byteArray : bytes)
            for(byte currentByte : byteArray) {
                result[i] = currentByte;
                i++;
            }

        return result;
    }

    /**
     * Suppression des final.
     */
    public static byte[] exercice4_v03(byte[]... bytes) {
        List<Byte> list = new LinkedList<>();

        for(byte[] byteArray : bytes)
            for(byte currentByte : byteArray)
                list.add(currentByte);

        byte[] result = new byte[list.size()];

        for(int i = 0; i < list.size(); i++)
            result[i] = list.get(i);

        return result;
    }

    /**
     * Passage par les types primitifs.
     */
    public static byte[] exercice4v_02(final byte[]... bytes) {
        List<Byte> list = new LinkedList<>();

        for(final byte[] byteArray : bytes) {
            for(final byte currentByte : byteArray) {
                list.add(currentByte);
            }
        }

        final byte[] result = new byte[list.size()];

        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    /**
     * Version fournie dans le TP.
     */
    public static byte[] exercice4_v01(final byte[]... bytes) {
        List<Byte> list = new LinkedList<>();

        for(final byte[] byteArray : bytes) {
            for(final Byte currentByte : byteArray) {
                list.add(currentByte);
            }
        }

        final byte[] result = new byte[list.size()];

        for(Integer i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
