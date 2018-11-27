package benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.infra.Blackhole;


public class CPaintingBenchmark {
    @Benchmark @Fork(1)
    public void testMultiply(Blackhole blackhole) {
        // blackhole.consume();
    }
}
