package figures;

import java.awt.Graphics;
import java.awt.*;

public abstract class Figure {
    int x, y;
    int r1,g,b;
    Color cor;
    public abstract void paint (Graphics g);
}
