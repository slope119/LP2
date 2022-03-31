package figures;

import java.awt.Graphics;
import java.awt.*;

public abstract class Figure {
    public int x, y, w, h;
    int r1,g,b;
    int r2,g2,b2;
    Color corf, corl;
    public abstract void paint (Graphics g);
}
