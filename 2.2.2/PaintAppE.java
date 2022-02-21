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
        this.e1 = new Ellipse(50,100, 100,30);
        this.e2 = new Ellipse(50,200, 100,30);
        this.e3 = new Ellipse(200,100, 100,30);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        super.paint(g);
        g2d.setPaint(Color.blue);
        this.e1.fill(g);
        g2d.setPaint(Color.red);
        this.e1.paint(g);

        //super.paint(g);
        g2d.setPaint(Color.green);
        this.e2.fill(g);
        g2d.setPaint(Color.yellow);
        this.e2.paint(g);

        //super.paint(g);
        g2d.setPaint(Color.black);
        this.e3.fill(g);
        g2d.setPaint(Color.orange);
        this.e3.paint(g);
        
    }
}

class Ellipse {
    int x, y;
    int w, h;

    Ellipse (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }

    void fill (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }
}