import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class PaintAppE {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Ellipse e1,e2,e3;

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
        this.e1 = new Ellipse(50,100, 100,30, new Color(255,0,0), new Color(0,0,255));
        this.e2 = new Ellipse(50,200, 100,30, new Color(255,255,0), new Color(0,204,0));
        this.e3 = new Ellipse(200,100, 100,30, new Color(255,153,0), new Color(0,0,0));
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        super.paint(g);
       
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
        
    }
}

class Ellipse {
    int x, y;
    int w, h;
    Color linha, fundo;

    Ellipse (int x, int y, int w, int h, Color linha, Color fundo){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.linha = linha;
        this.fundo = fundo;
    }

    void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(this.fundo);
        g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        
        g2d.setPaint(this.linha);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }
}