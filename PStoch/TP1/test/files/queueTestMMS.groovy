package files

import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals

class queueTestMMS {
    private MMS queue;

    @Before
    public void setUp() throws Exception {
        // TODO.
        double lambda = 0.0;
        double mu = 0.0;
        int s = 0;
        queue = new MMS(lambda, mu, s);
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
