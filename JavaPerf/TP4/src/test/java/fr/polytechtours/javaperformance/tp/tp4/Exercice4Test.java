package fr.polytechtours.javaperformance.tp.tp4;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Test;

public class Exercice4Test {

    @Test
    public void testExercice4() throws DecoderException {
        Assert.assertArrayEquals(
                Hex.decodeHex("0123456789abcdef"),
                Exercice4.exercice4(
                        Hex.decodeHex("0123"),
                        Hex.decodeHex("4567"),
                        Hex.decodeHex("89"),
                        Hex.decodeHex("ab"),
                        Hex.decodeHex("cdef")
                        ));

        Assert.assertArrayEquals(
                Hex.decodeHex("00112233445566778899AABBCCDDEEFF"),
                Exercice4.exercice4(
                        Hex.decodeHex("00"),
                        Hex.decodeHex("11"),
                        Hex.decodeHex("22"),
                        Hex.decodeHex("33"),
                        Hex.decodeHex("44"),
                        Hex.decodeHex("55"),
                        Hex.decodeHex("66"),
                        Hex.decodeHex("77"),
                        Hex.decodeHex("88"),
                        Hex.decodeHex("99"),
                        Hex.decodeHex("AA"),
                        Hex.decodeHex("BB"),
                        Hex.decodeHex("CC"),
                        Hex.decodeHex("DD"),
                        Hex.decodeHex("EE"),
                        Hex.decodeHex("FF")
                ));
    }
}
