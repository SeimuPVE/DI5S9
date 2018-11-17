package benchmarks;

import fr.polytechtours.javaperformance.tp.tp4.Exercice5;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.infra.Blackhole;

import java.lang.reflect.InvocationTargetException;


public class BenchmarkExercice5 {
    @Benchmark @Fork(1)
    public void testExercice5(Blackhole blackhole) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        blackhole.consume(Exercice5.getName(new Exercice5.Guy("bob")));
        blackhole.consume(Exercice5.getName(new Exercice5.Guy("dylan")));
        blackhole.consume(Exercice5.getName(new Exercice5.Guy("marley")));
    }
}
