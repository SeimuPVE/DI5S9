package queues

import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals


class queueTestMM1K {
    private MM1K queue;

    @Before
    public void setUp() throws Exception {
        // TODO.
        double lambda = 3.0;
        double mu = 4.0;
        int k = 3;
        queue = new MM1K(lambda, mu, k);
    }

    @Test
    void testRho() {
        assertEquals(3/4, queue.getRho(), 0.01);
    }
    @Test
    void testQ0() {
        assertEquals(0.366, queue.getQ0(), 0.01);
    }

    @Test
    public void testL() {
        assertEquals(1.15, queue.getL(), 0.01);
    }

    @Test
    public void testLq() {
        assertEquals(0.51, queue.getLq(), 0.01);
    }
}
