package ivisible;
import ivisible.IVisible;

import figures.Rect;
import figures.Ellipse;
import figures.Figure;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.Graphics;

public class Button implements IVisible{
	int x,y,w,h;
	public int kind;
	//1 quadrado
	//2 retangulo
	//3 circulo
	//4 elipse
	Figure fig;

	public Button (int x, int y, int w, int h, int kind){
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
		this.kind = kind;
	}

	public boolean clicked(int x, int y){
		if((this.x <= x) && (this.y <= y) && (this.w + this.x > x) && (this.h + this.y > y)){
            return true;
        }
        else{
            return false;
        }
	}

	public void paint(Graphics g, boolean focused){
		Graphics2D g2d = (Graphics2D) g;
		if(focused == true){
			g2d.setPaint(new Color(102, 102, 102));
			g2d.fillRect(this.x,this.y, this.w,this.h);
		}
		else if(focused == false){
			g2d.setPaint(new Color(255,255,255));
			g2d.fillRect(this.x,this.y, this.w,this.h);
		}
		g2d.setPaint(new Color(0,0,0));
		g2d.drawRect(this.x,this.y, this.w,this.h);

		if(this.kind == 1){
			g2d.fillRect(this.x + 10,this.y + 10, this.w - 20,this.h - 20);
		}
		if(this.kind == 2){
			g2d.fillRect(this.x + 8,this.y + 15, this.w - 15,this.h - 30);
		}
		if(this.kind == 3){
			g2d.fill(new Ellipse2D.Double(this.x + 10 ,this.y + 10, this.w - 20,this.h - 20));
		}
		if(this.kind == 4){
			g2d.fill(new Ellipse2D.Double(this.x + 8,this.y + 15, this.w - 15,this.h - 30));
		}
	}
}