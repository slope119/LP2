import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.*;

class PackApp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Line l1,l2;
    Rect r1,r2;
    Ellipse e1,e2;

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java Packages");
        this.setSize(350, 350);
        this.l1 = new Line(50,150, 150,175, new Color(0,0,102));
        this.l2 = new Line(200,150, 300,175, new Color(255,0,0));
        this.r1 = new Rect(50,50, 100,30, new Color(255,0,0), new Color(0,0,255));
        this.r2 = new Rect(200,50, 100,30, new Color(255,153,0), new Color(0,0,0));
        this.e1 = new Ellipse(50,100, 100,30, new Color(255,153,0), new Color(0,0,0));
        this.e2 = new Ellipse(200,100, 100,30, new Color(255,255,0), new Color(0,204,0));
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.l1.paint(g);
        this.l2.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
    }
}