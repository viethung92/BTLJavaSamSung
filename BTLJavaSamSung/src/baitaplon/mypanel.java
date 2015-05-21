package baitaplon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public abstract class mypanel extends JPanel implements MouseListener {
	public Graphics g;
	public Color c=Color.black;
	public float x=0,y=0;
	public mypanel(){
		super();
		this.setLayout(null);
		this.addMouseListener(this);
	}
	public float getx(){return x;}
	public float gety(){return y;}
	public void setcolor(Color cl){
		c=cl;
	}
	public Color getcolor(){return c;}
	public void drawline(int x1,int y1,int x2,int y2){
		g=this.getGraphics();
		g.setColor(c);
		g.drawLine(x1, y1, x2, y2);
	}
	public void drawstring(String s,int x,int y){
		g=this.getGraphics();
		g.setColor(Color.gray);
		g.drawString(s, x, y);
	}
	
	public void mouseClicked(MouseEvent e) {
		x=this.getMousePosition().x;
		y=this.getMousePosition().y;
	}
}
