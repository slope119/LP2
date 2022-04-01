import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.Rect;
import figures.Ellipse;
import figures.Figure;

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
                    for (int i=0; i < figs.size(); i++){
                        if((figs.get(i).x <= evt.getX()) && (figs.get(i).y <= evt.getY()) && (figs.get(i).w + figs.get(i).x > evt.getX()) && (figs.get(i).h + figs.get(i).y > evt.getY())){
                            focus=figs.get(i);
                            figs.remove(figs.get(i));
                            figs.add(focus);
                        }
                    }
                    for (int i=0; i < figs.size(); i++){
                        if((figs.get(i).x <= evt.getX()) && (figs.get(i).y <= evt.getY()) && (figs.get(i).w + figs.get(i).x > evt.getX()) && (figs.get(i).h + figs.get(i).y > evt.getY())){
                            focus=figs.get(i);
                            figs.remove(figs.get(i));
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
                    if(focus != null){
                        focus.drag(evt.getX(),evt.getY());
                    }
                    repaint();
                }
            }
        );


        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    setFocusTraversalKeysEnabled(false);
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
                    int h = rand.nextInt(75);
                    int w = rand.nextInt(75 - h) + h + 15;
                    if (evt.getKeyChar() == 'r') {
                        mx = p.x - getLocation().x;
                        my = p.y - getLocation().y;
                        Rect r = new Rect(mx,my, w,h, new Color(r1,g,b), new Color(r2,g2,b2));
                        focus = r;
                        figs.add(r);
                    } 
                    else if (evt.getKeyChar() == 'e') {
                        mx = p.x - getLocation().x;
                        my = p.y - getLocation().y;
                        Ellipse e = new Ellipse(mx,my, w,h,new Color(r1,g,b), new Color(r2,g2,b2));
                        focus = e;
                        figs.add(e);
                    }
                    else if (evt.getKeyChar() == 'q') {
                        mx = p.x - getLocation().x;
                        my = p.y - getLocation().y;
                        Rect q = new Rect(mx,my, h,h, new Color(r1,g,b), new Color(r2,g2,b2));
                        focus = q;
                        figs.add(q);
                    }
                    else if (evt.getKeyChar() == 'c') {
                        mx = p.x - getLocation().x;
                        my = p.y - getLocation().y;
                        Ellipse c = new Ellipse(mx,my, h,h,new Color(r1,g,b), new Color(r2,g2,b2));
                        focus = c;
                        figs.add(c);
                    }
                    else if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
                        if(focus!= null){
                            figs.remove(figs.size()-1);
                            focus = null;
                        }
                    }
                    else if (evt.getKeyCode() == 107) {
                        if(focus!= null){
                            figs.get(figs.size()-1).resizeu();
                            focus = figs.get(figs.size()-1);
                        }
                    }
                    else if (evt.getKeyCode() == 109) {
                        if(focus!= null){
                            figs.get(figs.size()-1).resized();
                            focus = figs.get(figs.size()-1);
                        }
                    }
                    else if (evt.getKeyCode() == KeyEvent.VK_TAB) {
                        focus=figs.get(0);
                        figs.remove(figs.get(0));
                        figs.add(focus);
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
            if(fig == focus){
                fig.paint1(g);
            }
            else{
                fig.paint(g);
            }
            //fig.paint(g);
        }
    }
}
