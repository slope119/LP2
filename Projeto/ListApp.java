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
                    for (int i=0; i < figs.size(); i++){
                        if((figs.get(i).x <= prx) && (figs.get(i).y <= pry) && (figs.get(i).w + figs.get(i).x > prx) && (figs.get(i).h + figs.get(i).y > pry)){
                            focus=figs.get(i);
                            figs.remove(figs.get(i));
                            figs.add(focus);
                        }
                    }
                    for (int i=0; i < figs.size(); i++){
                        if((figs.get(i).x <= prx) && (figs.get(i).y <= pry) && (figs.get(i).w + figs.get(i).x > prx) && (figs.get(i).h + figs.get(i).y > pry)){
                            focus=figs.get(i);
                            figs.remove(figs.get(i));
                            figs.add(focus);
                        }
                    }
                    if(focus != null){
                        difx = focus.x - prx;
                        dify = focus.y - pry;
                    }
                    a = false;
                    if(focus != null){
                        if(((focus.x + focus.w - 10) <= prx) && ((focus.y + focus.h - 10) <= pry) && ((focus.y + focus.h - 10 + 10) > pry) && ((focus.x + focus.w - 10 + 10) > prx)){
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
                        if(evt.getX() - focus.x >= 20){
                            focus.w = evt.getX() - focus.x;
                        }
                        else{

                        }
                        if(evt.getY() - focus.y >= 20){
                            focus.h = evt.getY() - focus.y;
                        }
                        else{

                        }
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
                            figs.get(figs.size()-1).corl = new Color(r1,g,b);
                            figs.get(figs.size()-1).corf = new Color(r2,g2,b2);
                        }
                    }
                    else if (evt.getKeyChar() == 'w'){
                        if (focus != null){
                            figs.get(figs.size()-1).y -= 15;
                        }
                    }
                    else if (evt.getKeyChar() == 'a'){
                        if (focus != null){
                            figs.get(figs.size()-1).x -= 15;
                        }
                    }
                    else if (evt.getKeyChar() == 's'){
                        if (focus != null){
                            figs.get(figs.size()-1).y += 15;
                        }
                    }
                    else if (evt.getKeyChar() == 'd'){
                        if (focus != null){
                            figs.get(figs.size()-1).x += 15;
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
                            if(figs.get(figs.size()-1).w > 20 && figs.get(figs.size()-1).h > 20){
                                figs.get(figs.size()-1).resized();
                                focus = figs.get(figs.size()-1);
                            }
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




//*****4 figura implementada******
//*****deletar com delete implementado******
//***********mouse listener e motion listener implementados**********
//**********pra fazer a figura surgir no mouse eu implemento uma detecçao do xy atual dele e uso como coordenadas xy na hora de criar a figura*************




//drag é pegar e sempre atualizar o x,y relacionado a figura em foco // repaint() no final pra ficar sempre atualizando (nao acho que seja uma preocupação)
//z order pode ser feito com uma variavel do tipo booleana (acho q so de colocar o foco no final da lista ja da certo)
//tab pra trocar o foco pega sempre o primeiro elemento da lista e taca pro final
//array com retangulo adaptavel, um retangulo nulo e outro vermelho q se adapta ao w,h,x,y da figura em foco atual
//o highlight pode ser feito armazenando as informaçoes RGB e deixando a figura vermelha ou ent criando o retangulo


//if focus != null{
//    colorir a figura de vermelho;
//} 

//criar uma nova função de paint pra fazer a marcação
//if fig==foco{
//    fig.paint1(g);
//}

//a funçao drag tem q estar dentro das figuras (com as setinhas puxa essa mesma funçao)





///TA PEGANDO O XY ATUAL E SOMANDO