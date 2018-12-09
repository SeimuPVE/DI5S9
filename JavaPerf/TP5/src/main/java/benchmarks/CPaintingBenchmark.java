package benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.polytechtours.performance.tp.fourmispeintre.CPainting;
import org.polytechtours.performance.tp.fourmispeintre.PaintingAnts;

import java.awt.*;


public class CPaintingBenchmark {
    @Benchmark @Fork(1)
    public void setCouleur() {
        PaintingAnts paintingAnts = new PaintingAnts();
        paintingAnts.init();
        CPainting cPainting = new CPainting(new Dimension(10, 10), paintingAnts);
        Color c = new Color(96, 255, 112);
        int i, j, k;

        for(i = 0; i < 10; i++)
            for(j = 0; j < 10; j++)
                for(k = 1; k < 4; k++)
                    cPainting.setCouleur(i, j, c, k);
    }
}
