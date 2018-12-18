package org.polytechtours.performance.tp.fourmispeintre.colors;

import java.util.ArrayList;


public class HistoryColor {
    public static final int MAX_SIZE = 100000;
    public static final int MIN_USE = 100;
    private ArrayList<PaintingColor> colors;
    private int usedRate[];

    public HistoryColor() {
        usedRate = new int[MAX_SIZE];
        colors = new ArrayList<>();
    }

    public boolean contains(PaintingColor testedColor) {
        return colors.contains(testedColor);
    }

    public int size() {
        return colors.size();
    }

    public int indexOf(PaintingColor testedColor) {
        return colors.indexOf(testedColor);
    }

    public PaintingColor get(int indexOf) {
        return colors.get(indexOf);
    }

    public void add(PaintingColor paintingColor) {
        if(size() >= MAX_SIZE)
            if(retract()) {
                colors.add(paintingColor);
                usedRate[colors.size() - 1] = 1;
            }
    }

    public boolean retract() {
        int new_use_rate[] = new int[MAX_SIZE];
        int min = 99999, position = -1, i;

        for(i = 0; i < usedRate.length; i++)
            if(usedRate[i] < min) {
                min = usedRate[i];
                position = i;
            }

        if(min >= MIN_USE) {
            colors.remove(position);

            for(i = 0; i < usedRate.length; i++)
                if(i != position)
                    new_use_rate[i] = usedRate[i];
            usedRate = new_use_rate;

            return true;
        }

        return false;
    }

    public PaintingColor incrementAndGet(int indexOf) {
        usedRate[indexOf]++;
        return get(indexOf);
    }
}
