package baitaplon;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
	
	public float x(float k){
		return (k-ox)/scalex;
	}
	public float y(String s,float m){
		
		return Main.kq(m,s);
	}
	public int yp(float l){
		return (int)(-l*scaley+oy);
	}
	public void ve(String s,mypanel p,Color c){
		p.setcolor(c);
		for(x=0;x<600;x++)
		{
			p.drawline(x,yp(y(s,x(x))),x+1,yp(y(s,x(x+1))));
		}
		
	}
	
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

	public myframe(String s){
		super(s);
		this.setSize(1000, 700);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myfr=this;
		
		function=new ArrayList<>();
		clrc =new JColorChooser();
		clrc.setBounds(650, 30, 300, 300);
		this.add(clrc);
		clrc.setColor(Color.black);
		clrc.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				mp.setcolor(clrc.getColor());
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {

			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		
		draw=new JButton("draw");
		draw.setBounds(650, 400, 100, 40);
		this.add(draw);
		draw.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				function.add(str);
			}
		});
		
		cancle=new JButton("delete");
		cancle.setBounds(850, 400, 100, 40);
		this.add(cancle);
		cancle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if(!function.isEmpty())
				{
					del=true;
				}
				vetruc();
			}
		});
				
		type=new ButtonGroup();
		type.add(b1);
		type.add(b2);
		
		ly=new JLabel("y=");
		ly.setBounds(180, 600, 100, 20);
		this.add(ly);
		
		ta=new JTextField("0");
		ta.setBounds(200, 600, 400, 40);
		this.add(ta);
		ta.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				str=ta.getText().toString();
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {

			}
		});
		
		ltt=new JLabel("selected point (x:y)",(int) CENTER_ALIGNMENT);
		ltt.setBounds(730, 430, 150, 40);
		this.add(ltt);
		
		tttx=new JTextField();
		tttx.setBounds(640, 470, 150, 40);
		tttx.setText("0");
		this.add(tttx);
		
		ttty=new JTextField();
		ttty.setBounds(820, 470, 150, 40);
		ttty.setText("0");
		this.add(ttty);
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				mp=new mypanel() {

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						tttx.setText(String.valueOf(this.getx()/30-10));
						ttty.setText(String.valueOf(-this.gety()/30+10));
					}
					
				};
				mp.setBounds(30, 30, 600, 500);
				mp.setBackground(Color.white);
				myfr.add(mp);
				mp.setcolor(Color.black);//dat mau mac dinh khi ve do thi
				while (true)
				{
					vetruc();
					if(!function.isEmpty())
						{
							for(int i=0;i<function.size();i++)
							{
								String s=function.get(i);
								ve(s,mp, mp.getcolor());
								try {
									Thread.sleep(100);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							if(del==true)
							{
								String s=function.get(function.size()-1);
								Color c=mp.getcolor();
								ve(s,mp,Color.white);
								function.remove(function.size()-1);
								del=false;
								mp.setcolor(c);
							}
						}
				}
			}
		});
		t.start();
	}
}
