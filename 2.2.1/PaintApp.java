import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Rect r1,r2,r3;

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Painting Figures");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100,30, new Color(255,0,0), new Color(0,0,255));
        this.r2 = new Rect(50,100, 100,30, new Color(255,255,0), new Color(0,204,0));
        this.r3 = new Rect(200,50, 100,30, new Color(255,153,0), new Color(0,0,0));
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        super.paint(g);
        
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    Color linha,fundo;

    Rect (int x, int y, int w, int h, Color linha, Color fundo) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.linha = linha;
        this.fundo = fundo;

    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(this.fundo);
        g2d.fillRect(this.x,this.y, this.w,this.h);

        g2d.setPaint(this.linha);
        g2d.drawRect(this.x,this.y, this.w,this.h);
    }

}