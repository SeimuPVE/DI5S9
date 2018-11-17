package benchmarks;

import fr.polytechtours.javaperformance.tp.tp4.Exercice3a;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.ExecutionException;


public class BenchmarkExercice3a {
    @Benchmark @Fork(1)
    public void testExercice3a(Blackhole blackhole) throws ExecutionException, InterruptedException {
        blackhole.consume(new Exercice3a().exercice3a(4, 10).intValue());
    }
}
