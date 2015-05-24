package baitaplon;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class myframe extends JFrame{

	public int scalex=30;
	public int scaley=30;
	public int ox=300;
	public int oy=300;
	public static ArrayList<String> function;
	public static String str;
	public static mypanel mp;
	public static JColorChooser clrc;
	public static JButton draw,cancle,confirm,btntt,vt;
	public static ButtonGroup type;
	public static JRadioButton b1,b2;
	public static JLabel ly,ltt,hc;
	public static JTextField ta,tttx,ttty;
	public static int y,x,i,j;
	public static float a,b,c;
	public static boolean del=false;
	public static myframe myfr;
	public Point po=new Point();
	
	public void vetruc(){
		Color c=mp.getcolor(); //luu mau sac cua do thi 
		mp.setcolor(Color.black);//chuyen sang mau den de ve truc 
		mp.drawline(0, oy, 600, oy);
		mp.drawline(595, oy-5, 600, oy);
		mp.drawline(595, oy+5, 600, oy);
		mp.drawline(ox, 0, ox, 500);
		mp.drawline(ox, 0, ox+5, 5);
		mp.drawline(ox, 0, ox-5, 5);
		mp.drawstring("x", 570, oy-30);
		mp.drawstring("y", ox+30, 30);
		for(int x=0;x<570;x=x+scalex){
			if((x-ox)%scalex==0)
			{
				mp.drawline(x, oy-1, x, oy+1);
				mp.drawstring(String.valueOf(x/scalex-oy/scalex), x-10, oy+20);
			}
		}
		for(int x=0;x<500;x=x+30){
			if((x-oy)%30==0&&x!=oy)
			{
				mp.drawline(ox-1, x, ox+1, x);
				mp.drawstring(String.valueOf((oy-x)/scaley), ox+5, x);
			}
		}
		mp.setcolor(c);//chuyen sang mau ve do thi
	}

}
