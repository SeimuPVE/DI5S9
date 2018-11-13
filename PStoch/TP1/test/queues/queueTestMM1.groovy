package queues

import org.junit.Before
import org.junit.Test;
import static org.junit.Assert.assertEquals;


class queueTestMM1 {
    private MM1 queue;

    @Before
    public void setUp() throws Exception {
        double lambda = 10.0;
        double mu = 12.0;
        queue = new MM1(lambda, mu);
    }

    @Test
    void testRho() {
        assertEquals(10/12, queue.getRho(), 0.01);
    }

    @Test
    public void testL() {
        assertEquals(5.0, queue.getL(), 0.01);
    }

    @Test
    public void testLq() {
        assertEquals(4.16, queue.getLq(), 0.01);
    }

    @Test
    public void testW() {
        assertEquals(0.5, queue.getW(), 0.01);
    }

    @Test
    public void testWq() {
        assertEquals(0.42, queue.getWq(), 0.01);
    }
}
