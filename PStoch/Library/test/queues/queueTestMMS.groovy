package queues

import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals

class queueTestMMS {
    private MMS queue;

    @Before
    public void setUp() throws Exception {
        // TODO.
        double lambda = 10.0;
        double mu = 12.0;
        int s = 2;
        queue = new MMS(lambda, mu, s);
    }

    @Test
    void testRho() {
        assertEquals(5/12, queue.getRho(), 0.01);
    }

    @Test
    void testQ0() {
        assertEquals(7/17, queue.getQ0(), 0.01);
    }

    @Test
    public void testL() {
        assertEquals(1.01, queue.getL(), 0.01);
    }

    @Test
    public void testLq() {
        assertEquals(0.175, queue.getLq(), 0.01);
    }

    @Test
    public void testW() {
        assertEquals(0.101, queue.getW(), 0.01);
    }

    @Test
    public void testWq() {
        assertEquals(0.018, queue.getWq(), 0.01);
    }
}
