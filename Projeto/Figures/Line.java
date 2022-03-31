package figures;

import java.awt.*;

public class Line extends Figure{
    int x2, y2;

    public Line (int x, int y, int x2, int y2, Color corl) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
        this.corl = corl;

    }

    public void print () {
        System.out.format("Linha que vai do ponto (%d,%d) ao ponto (%d,%d)\n",
            this.x, this.y, this.x2, this.y2);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(this.corl);
        g2d.drawLine(this.x,this.y,this.x2,this.y2);
    }

}