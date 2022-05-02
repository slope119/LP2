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

    private void print () {
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
    public int getX(){
        return(this.x);
    }
    public int getY(){
        return(this.y);
    }
    public void movew(){
        this.y -= 15;
    }
    public void movea(){
        this.x -= 15;
    }
    public void moves(){
        this.y += 15;
    }
    public void moved(){
        this.x += 15;
    }
    public void resizeu(){
        this.x-=5;
        this.y-=5;
        this.w+=10;
        this.h+=10;
    }
    public void resized(){
        if(this.w > 20 && this.h > 20){
            this.x+=5;
            this.y+=5;
            this.w-=10;
            this.h-=10;
        }
    }
    public void recolor(int r1, int g, int b, int r2, int g2, int b2){
        this.corl = new Color(r1,g,b);
        this.corf = new Color(r2,g2,b2);
    }
    public void drag(int dx, int dy, int difx, int dify) {
        this.x = dx + difx;
        this.y = dy + dify;
    }
    public boolean clicked(int prx, int pry){
        if((this.x <= prx) && (this.y <= pry) && (this.w + this.x > prx) && (this.h + this.y > pry)){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean clickeds(int prx, int pry){
        if(((this.x + this.w - 10) <= prx) && ((this.y + this.h - 10) <= pry) && ((this.y + this.h - 10 + 10) > pry) && ((this.x + this.w - 10 + 10) > prx)){
            return true;
        }
        else{
            return false;
        }
    }
    public void resize(int x, int y){
        if(x - this.x >= 20){
            this.w = x - this.x;
        }
        else{

        }
        if(y - this.y >= 20){
            this.h = y - this.y;
        }
        else{

        }
    }
}