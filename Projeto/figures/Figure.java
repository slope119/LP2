package figures;

import ivisible.IVisible;

import java.awt.Graphics;
import java.awt.*;

public abstract class Figure implements IVisible{
    int x, y, w, h;
    Color corfocus = new Color(255, 0, 0);
    int r1,g,b;
    int r2,g2,b2;
    Color corf, corl;
    public abstract void resizeu ();
    public abstract void resized ();
    public abstract void drag (int dx,int dy, int difx, int dify);
    public abstract boolean clicked(int prx, int pry);
    public abstract boolean clickeds(int prx, int pry);
    public abstract void resize(int x, int y);
    public abstract void movew();
    public abstract void movea();
    public abstract void moves();
    public abstract void moved();
    public abstract int getX();
    public abstract int getY();
    public abstract void recolor(int r1, int g, int b, int r2, int g2, int b2);
}
