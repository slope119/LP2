import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 350);
        this.setVisible(true);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.blue);
        int w = getWidth();
        int h = getHeight();

        g2d.setPaint(Color.black);
        g2d.fill (new Rectangle2D.Double(0, 0,w,h));

        g2d.setPaint(Color.blue);
        g2d.drawLine(0,0, w,h);
        g2d.drawLine(0,h, w,0);
        g2d.draw(new Ellipse2D.Double(175, 175,85,85));
        g2d.draw(new Ellipse2D.Double(87, 87,87,87));
        g2d.draw(new Ellipse2D.Double(175, 87,87,87));
        g2d.draw(new Ellipse2D.Double(87, 175,87,87));

        g2d.setPaint(Color.red);
        g2d.fill (new Ellipse2D.Double(175, 175,87,87));
        g2d.fill (new Ellipse2D.Double(87, 87,87,87));
        g2d.fill (new Ellipse2D.Double(175, 87,87,87));
        g2d.fill (new Ellipse2D.Double(87, 175,87,87));
    }
}



//tenho que mudar a cor do fundo: fazer um retangulo que cobre o frame inteiro e tb tenho q colorir as linhas diferentemente.