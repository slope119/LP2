package figures;

import java.awt.*;

public class Line {
    int x1, y1;
    int x2, y2;
    Color linha;

    public Line (int x1, int y1, int x2, int y2, Color linha) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.linha = linha;

    }

    public void print () {
        System.out.format("Linha que vai do ponto (%d,%d) ao ponto (%d,%d)\n",
            this.x1, this.y1, this.x2, this.y2);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(this.linha);
        g2d.drawLine(this.x1,this.y1,this.x2,this.y2);
    }

}