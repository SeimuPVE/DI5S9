import org.junit.jupiter.api.Test;
import util.LoiBeta;
import util.LoiSimulateur;

public class TestBeta {
    @Test
    public void testBeta(){
        for(int i = 0;i<100;i++){
            System.out.println(LoiSimulateur.loi_beta(2.5,6.4));
//            System.out.println(LoiSimulateur.loi_exp(0.175));
        }

    }
}
