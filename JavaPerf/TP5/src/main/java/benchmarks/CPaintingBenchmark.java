package benchmarks;


public class CPaintingBenchmark {
    @Benchmark @Fork(1)
    public void testMultiply(Blackhole blackhole) {
        // blackhole.consume();
    }
}
