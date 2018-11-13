package queues

import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals


class queueTestMM1K {
    private MM1K queue;

    @Before
    public void setUp() throws Exception {
        // TODO.
        double lambda = 0.0;
        double mu = 0.0;
        int k = 0;
        queue = new MM1K(lambda, mu, k);
    }

    @Test
    void testQ0() {
        // TODO.
        assertEquals(0.1, queue.getQ0());
    }

    @Test
    public void testL() {
        // TODO.
        assertEquals(0.1, queue.getL());
    }

    @Test
    public void testLq() {
        // TODO.
        assertEquals(0.1, queue.getLq());
    }

    @Test
    public void testW() {
        // TODO.
        assertEquals(0.1, queue.getW());
    }

    @Test
    public void testWq() {
        // TODO.
        assertEquals(0.1, queue.getWq());
    }
}
