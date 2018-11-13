package benchmarks;

import fr.polytechtours.javaperformance.tp.tp4.Exercice1;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.infra.Blackhole;


public class BenchmarkExercice1 {
    @Benchmark @Fork(1)
    public void testMultiply(Blackhole blackhole) {
        final int[][] matrix = {
                {1, 1, 2, 2, 2, 1, 1},
                {1, 2, 3, 4, 3, 2, 1},
                {2, 3, 4, 5, 4, 3, 2},
                {2, 4, 5, 8, 5, 4, 2},
                {2, 3, 4, 5, 4, 3, 2},
                {1, 2, 3, 4, 3, 2, 1},
                {1, 1, 2, 2, 2, 1, 1}
        };

        final float[][] multiply = Exercice1.multiply(matrix);
        blackhole.consume(multiply);
        blackhole.consume(multiply.length);
        blackhole.consume(multiply[0]);
        blackhole.consume(multiply[1]);
        blackhole.consume(multiply[2]);
        blackhole.consume(multiply[3]);
        blackhole.consume(multiply[4]);
        blackhole.consume(multiply[5]);
        blackhole.consume(multiply[6]);
    }
}
