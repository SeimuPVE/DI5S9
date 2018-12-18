package org.polytechtours.performance.tp.fourmispeintre.colors;

import java.awt.*;


public class PaintingColor {
    private int x;
    private int y;
    private Color c;
    private int pTaille;
    private Color lColor;

    public PaintingColor(int x, int y, Color c, int pTaille, Color lColor) {
        this.x = x;
        this.y = y;
        this.c = c;
        this.pTaille = pTaille;
        this.lColor = lColor;
    }

    public PaintingColor(int x, int y, Color c, int pTaille) {
        this(x, y, c, pTaille, null);
    }

    public Color getlColor() {
        return lColor;
    }

    public boolean equals(PaintingColor obj) {
        return (this.x == obj.x && this.y == obj.y && this.c.equals(obj.c) && this.pTaille == obj.pTaille);
    }
}
