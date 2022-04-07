package figures;

import java.awt.*;

public class Rect extends Figure {

    public Rect (int x, int y, int w, int h, Color corl, Color corf) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.corl = corl;
        this.corf = corf;
    }

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(this.corf);
        g2d.fillRect(this.x,this.y, this.w,this.h);
        g2d.setPaint(this.corl);
        g2d.drawRect(this.x,this.y, this.w,this.h);
    }
    public void paint1 (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(this.corf);
        g2d.fillRect(this.x,this.y, this.w,this.h);
        g2d.setPaint(this.corl);
        g2d.drawRect(this.x,this.y, this.w,this.h);g2d.setPaint(this.corfocus);
        g2d.drawRect(this.x - 5,this.y - 5,this.w + 10,this.h +10);
        g2d.setPaint(new Color(0,0,0));
        g2d.fillRect(this.x + this.w-10,this.y + this.h-10,10 ,10);
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
    public void drag(int dx, int dy, int difx, int dify) {
        this.x = dx + difx;
        this.y = dy + dify;
    }
}