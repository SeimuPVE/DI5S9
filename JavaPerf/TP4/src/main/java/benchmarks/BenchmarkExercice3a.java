package benchmarks;

import fr.polytechtours.javaperformance.tp.tp4.Exercice3a;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.ExecutionException;


public class BenchmarkExercice3a {
    @Benchmark @Fork(1)
    public void testExercice3a(Blackhole blackhole) throws ExecutionException, InterruptedException {
//        blackhole.consume(new Exercice3a().exercice3a(10, 500).intValue());
//        blackhole.consume(new Exercice3a().exercice3a(7, 5000).intValue());
//        blackhole.consume(new Exercice3a().exercice3a(2, 100000).intValue());
//        blackhole.consume(new Exercice3a().exercice3a(5, 5000000).intValue());
//        blackhole.consume(new Exercice3a().exercice3a(100, 3000000).intValue());
//        blackhole.consume(new Exercice3a().exercice3a(100, 5000000).intValue());
    }
}
