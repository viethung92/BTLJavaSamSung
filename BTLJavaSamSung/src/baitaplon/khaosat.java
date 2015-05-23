package baitaplon;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class khaosat extends JFrame {
	public int scalex=30;
	public int scaley=30;
	public int ox=300;
	public int oy=300;
	public static int y,x,i,j;
	public mypanel mp;
	public static boolean del=false;
	public ArrayList<String> finction;
	public JRadioButton rf1,rf2,rf3,rf4,rf5;
	public ButtonGroup bg;
	public String str;
	public float a=0,b=0,c=0,d=0,e=0,f=0,g=0;
	public boolean draw=false;
	public JLabel ly,la,lb,lc,ld,lf,lg; //lg la dau gach ngang phan so trong truong hop ham la phan so
	public JTextField tfa,tfb,tfc,tfd,tfe,tfg;
	public JTextArea te;
	public JButton btnks,btncancle;
	public khaosat ks;
	public Thread t;
	
	public float x(float k) {
		return (k-ox)/scalex;
	}
	
	public float y(String s,float m){
		return Main.kq(m,s);
	}
	
	public int yp(float l){
		return (int) (-1*scaley+oy);
	}
	
	public void ve(String s,mypanel p, Color c){
		p.setcolor(c);
		for(x=0;x<600;x++)
		{
			p.drawline(x,yp(y(s,x(x))),x+1,yp(y(s,x(x+1))));
		}
	}
	
	public khaosat(String s) {
		// TODO Auto-generated constructor stub
		super(s);
		this.setSize(1300,1700);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ks=this;
		function=new ArrayList<>();
		
		ly=new JLabel("y=");
		ly.setBounds(300,610,30,30);
		this.add(ly);
		la=new JLabel("x^4+");
		la.setBounds(360,570,30,30);
		this.add(la);
		la.hide();
		
		
	}


	

}
