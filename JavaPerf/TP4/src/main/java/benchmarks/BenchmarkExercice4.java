package benchmarks;

import fr.polytechtours.javaperformance.tp.tp4.Exercice4;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.infra.Blackhole;


public class BenchmarkExercice4 {
    @Benchmark @Fork(1)
    public void testExercice4(Blackhole blackhole) throws DecoderException {
        blackhole.consume(
                Exercice4.exercice4(
                        Hex.decodeHex("0123"),
                        Hex.decodeHex("4567"),
                        Hex.decodeHex("89"),
                        Hex.decodeHex("ab"),
                        Hex.decodeHex("cdef")
                ));

        blackhole.consume(
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
                ));    }
}
