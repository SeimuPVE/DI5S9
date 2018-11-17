package benchmarks;

import fr.polytechtours.javaperformance.tp.tp4.Exercice2;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.infra.Blackhole;


public class BenchmarkExercice2 {
    @Benchmark @Fork(1)
    public void testExercice3a(Blackhole blackhole) {
        blackhole.consume(Exercice2.fibonacci(43));
    }
}
