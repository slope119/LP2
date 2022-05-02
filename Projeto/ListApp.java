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
    int prx,pry;
    int difx, dify;
    boolean a = false;

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
                    prx = evt.getX();
                    pry = evt.getY();
                    for (int i=figs.size()-1; i >= 0; i--){
                        if(figs.get(i).clicked(prx,pry) == true){
                            focus=figs.get(i);
                            figs.remove(figs.get(i));
                            figs.add(focus);
                            break;
                        }
                    }
                    if(focus != null){
                        difx = focus.getX() - prx;
                        dify = focus.getY() - pry;
                    }
                    a = false;
                    if(focus != null){
                        if(focus.clickeds(prx,pry) == true){
                            a = true;
                        }
                    }
                    repaint();
                }
            }
        );


        this.addMouseMotionListener(
            new MouseMotionAdapter() {
                public void mouseDragged (MouseEvent evt){
                    if(a == true){
                        focus.resize(evt.getX(), evt.getY());
                    }
                    else if(focus != null){
                        focus.drag(evt.getX(),evt.getY(), difx, dify);
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
                    int h = rand.nextInt((130 - 30) + 30);
                    int w = rand.nextInt(130 - h) + h + 35;
                    if (evt.getKeyChar() == 'r') {
                        mx = p.x - getLocation().x;
                        my = p.y - getLocation().y;
                        Rect r = new Rect(mx,my, w + 10,h + 10, new Color(r1,g,b), new Color(r2,g2,b2));
                        focus = r;
                        figs.add(r);
                    } 
                    else if (evt.getKeyChar() == 'e') {
                        mx = p.x - getLocation().x;
                        my = p.y - getLocation().y;
                        Ellipse e = new Ellipse(mx,my, w + 10,h + 10,new Color(r1,g,b), new Color(r2,g2,b2));
                        focus = e;
                        figs.add(e);
                    }
                    else if (evt.getKeyChar() == 'q') {
                        mx = p.x - getLocation().x;
                        my = p.y - getLocation().y;
                        Rect q = new Rect(mx,my, h + 20,h + 20, new Color(r1,g,b), new Color(r2,g2,b2));
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
                    else if (evt.getKeyChar() == 'f'){
                        if(focus != null){
                            figs.get(figs.size()-1).recolor(r1, g, b, r2, g2, b2);
                        }
                    }
                    else if (evt.getKeyChar() == 'w'){
                        if (focus != null){
                            figs.get(figs.size()-1).movew();
                        }
                    }
                    else if (evt.getKeyChar() == 'a'){
                        if (focus != null){
                            figs.get(figs.size()-1).movea();
                        }
                    }
                    else if (evt.getKeyChar() == 's'){
                        if (focus != null){
                            figs.get(figs.size()-1).moves();
                        }
                    }
                    else if (evt.getKeyChar() == 'd'){
                        if (focus != null){
                            figs.get(figs.size()-1).moved();
                        }
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



//foco vai continuar funcionando depois de fazer uma lista ainda mais heterogenea com botoes e figuras

//foco vai determinar quando qualquer coisa é clicada, nao vai ter q ser mexido


//   (dentro do mouse listener)
//if(focus == botao r){
//    criar retangulo na posiçao atual do mouse apos o clique
//}

//para solucionar o tab vou ter q fazer uma forma inteligente de percorrer a lista e identificar se é um botao ou n
//provavelmente botar uma condiçao e fazer um += ao i para pular o elemento botao na lista

//solucionar problema de alternar clique de foco (ou não)

//fazer condiçao da area do clique para separar a interface, se clicar dentro so faz nada, se clicar fora cria a figura e torna o foco == null;
//fazer novas condições no metodo drag pra impedir que figuras fiquem sobre os botoes
//criar linhas para determinar a area da interface