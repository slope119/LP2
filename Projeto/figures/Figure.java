package figures;

import ivisible.IVisible;

import java.awt.Graphics;
import java.awt.*;

public abstract class Figure implements IVisible {
    public int x, y, w, h;
    Color corfocus = new Color(255, 0, 0);
    public int r1,g,b;
    public int r2,g2,b2;
    public Color corf, corl;
    public abstract void paint (Graphics g);
    public abstract void paint1 (Graphics g);
    public abstract void resizeu ();
    public abstract void resized ();
    public abstract void drag (int dx,int dy, int difx, int dify);
    public abstract boolean clicked(int prx, int pry);
}
