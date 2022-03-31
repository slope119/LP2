import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.Rect;
import figures.Ellipse;
import figures.Figure;
import figures.Line;


class ListApp{
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();
    Figure focus;

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );



        this.addMouseListener(
            new MouseAdapter() {
                public void mousePressed (MouseEvent evt){
                    focus =  null;
                    for (Figure fig: figs){
                        if((fig.x <= evt.getX()) && (fig.y <= evt.getY()) && (fig.w + fig.x > evt.getX()) && (fig.h + fig.y > evt.getY())){
                            focus=fig;
                            figs.remove(fig);
                            figs.add(focus);
                        }
                    }
                    repaint();
                }
            }
        );


        this.addMouseMotionListener(
            new MouseMotionAdapter() {
                public void mouseDragged (MouseEvent evt){
                    //aqui vai entrar a funçao de drag das figuras
                    repaint();
                }
            }
        );


        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    Point p = MouseInfo.getPointerInfo().getLocation();
                    int mx,my;
                    int r1 = rand.nextInt(255);
                    int g = rand.nextInt(255);
                    int b = rand.nextInt(255);
                    int r2 = rand.nextInt(255);
                    int g2 = rand.nextInt(255);
                    int b2 = rand.nextInt(255);
                    int x = rand.nextInt(350);
                    int y = rand.nextInt(350);
                    int w = rand.nextInt(50);
                    int h = rand.nextInt(50);
                    int x2 = rand.nextInt(350);
                    int y2 = rand.nextInt(350);
                    if (evt.getKeyChar() == 'r') {
                        mx = p.x - getLocation().x;
                        my = p.y - getLocation().y;
                        Rect r = new Rect(mx,my, 50,50, new Color(r1,g,b), new Color(r2,g2,b2));
                        figs.add(r);
                    } 
                    else if (evt.getKeyChar() == 'e') {
                        mx = p.x - getLocation().x;
                        my = p.y - getLocation().y;
                        figs.add(new Ellipse(mx,my, 50,100,new Color(r1,g,b), new Color(r2,g2,b2)));
                    }
                    else if (evt.getKeyChar() == 'l') {
                        mx = p.x - getLocation().x;
                        my = p.y - getLocation().y;
                        figs.add(new Line(mx,my, x2,y2, new Color(r1,g,b)));
                    }
                    else if (evt.getKeyChar() == 'c') {
                        mx = p.x - getLocation().x;
                        my = p.y - getLocation().y;
                        figs.add(new Ellipse(mx,my, 50,50,new Color(r1,g,b), new Color(r2,g2,b2)));
                    }
                    else if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
                        figs.remove(figs.size()-1);
                    }
                    repaint();
                }
            }
        );

        this.setTitle("Lista de Figuras");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}
