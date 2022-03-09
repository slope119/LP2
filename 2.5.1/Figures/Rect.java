package figures;

import java.awt.*;

public class Rect {
    int x, y;
    int w, h;
    //Color linha,fundo;

    //public Rect (int x, int y, int w, int h, Color linha, Color fundo){
    public Rect (int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        //this.linha = linha;
        //this.fundo = fundo;

    }

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //g2d.setPaint(this.fundo);
        //g2d.fillRect(this.x,this.y, this.w,this.h);

        //g2d.setPaint(this.linha);
        g2d.drawRect(this.x,this.y, this.w,this.h);
    }

}