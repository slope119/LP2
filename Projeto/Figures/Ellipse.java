package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figure {

    public Ellipse (int x, int y, int w, int h, Color corl, Color corf) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.corl = corl;
        this.corf = corf;
    }

    public void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(this.corf);
        g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        g2d.setPaint(this.corl);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }
    public void paint1 (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(this.corf);
        g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        g2d.setPaint(this.corl);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        g2d.setPaint(this.corfocus);
        g2d.drawRect(this.x - 5,this.y - 5,this.w + 10,this.h +10);
    }
    public void resizeu(){
        this.x-=5;
        this.y-=5;
        this.w+=10;
        this.h+=10;
    }
    public void resized(){
        this.x+=5;
        this.y+=5;
        this.w-=10;
        this.h-=10;
    }
    public void drag(int dx, int dy){
        this.x = dx;
        this.y = dy;
    }
}
