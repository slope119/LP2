package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Circle extends Figure {

    public Circle (int x, int y, int w, Color corl, Color corf) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.corl = corl;
        this.corf = corf;
    }

    public void print () {
        System.out.format("Circulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.w, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(this.corf);
        g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.w));
        g2d.setPaint(this.corl);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.w));
    }
}