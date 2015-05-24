package baitaplon;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
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
	public ArrayList<String> function;
	public JRadioButton rf1,rf2,rf3,rf4,rf5;
	public ButtonGroup bg;
	public String str;
	public float a=0,b=0,c=0,d=0,e=0,f=0,g=0;
	public boolean draw=false;
	public JLabel ly,la,lb,lc,ld,le,lf,lg; //lg la dau gach ngang phan so trong truong hop ham la phan so
	public JTextField tfa,tfb,tfc,tfd,tfe,tff,tfg;
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
		lb=new JLabel("x^3+");
		lb.setBounds(420,570,30,30);
		this.add(lb);
		lb.hide();
		lc.setBounds(480, 570, 30, 30);
		this.add(lc);
		lc.hide();
		lf=new JLabel("x+");
		ld=new JLabel("x+");
		ld.setBounds(540, 570, 30, 30);
		this.add(ld);
		ld.hide();
		lf=new JLabel("x+");
		lf.setBounds(360, 640, 30, 30);
		this.add(lf);
		lf.hide();
		lg=new JLabel("____________________________");
		lg.setBounds(330, 610,200 , 20);
		this.add(lg);
		lg.hide();
		
		tfa=new JTextField();
		tfa.setBounds(330,610,200,20);
		this.add(tfa);
		tfa.hide();
		tfa.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				a=Float.parseFloat(tfa.getText());
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		tfb=new JTextField();
		tfb.setBounds(390, 570, 30, 30);
		this.add(tfb);
		tfb.hide();
		tfb.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				b=Float.parseFloat(tfb.getText());
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		tfc=new JTextField();
		tfc.setBounds(450, 570, 30, 30);
		this.add(tfc);
		tfc.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				c=Float.parseFloat(tfc.getText());
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		tfd=new JTextField();
		tfd.setBounds(510, 570, 30, 30);
		this.add(tfd);
		tfd.hide();
		tfd.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				d=Float.parseFloat(tfd.getText());
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		tfe=new JTextField();
		tfe.setBounds(570, 570, 30, 30);
		this.add(tfe);
		tfe.hide();
		tfe.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				e=Float.parseFloat(tfe.getText());
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		tff=new JTextField();
		tff.setBounds(330, 640, 30, 30);
		this.add(tff);
		tff.hide();
		tff.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				f=Float.parseFloat(tff.getText());
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		tfg=new JTextField();
		tfg.setBounds(390, 640, 30, 30);
		this.add(tfg);
		tfg.hide();
		tfg.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				g=Float.parseFloat(tfg.getText());
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		te=new JTextArea();
		te.setBounds(700, 30, 530, 500);
		te.setEditable(false);
		this.add(te);
		
		rf1=new JRadioButton("y=ax^2+bx+c");
		rf1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				la.hide();
				tfa.hide();
				lb.hide();
				tfb.hide();
				tfc.show();
				lc.show();
				tfd.show();
				ld.show();
				le.show();
				tfe.show();
				lf.hide();
				tff.hide();
				lg.hide();
				tfg.hide();
			}
		});
		
		rf2=new JRadioButton("y=ax^3+bx^2+cx+d");
		rf2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				la.hide();
				tfa.hide();
				lb.show();
				tfb.show();
				tfc.show();
				lc.show();
				tfd.show();
				ld.show();
				le.show();
				tfe.show();
				lf.hide();
				tff.hide();
				lg.hide();
				tfg.hide();
			}
		});
		
		rf3=new JRadioButton("y=ax^4+bx^2+c");
		rf3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				la.show();
				tfa.show();
				lb.hide();
				tfb.hide();
				tfc.show();
				lc.show();
				tfd.hide();
				ld.hide();;
				le.show();
				tfe.show();
				lf.hide();
				tff.hide();
				lg.hide();
				tfg.hide();
			}
		});
		
		rf4=new JRadioButton("y=(ax^2+bx+c)/(ex+f)");
		rf4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				la.hide();
				tfa.hide();
				lb.hide();
				tfb.hide();
				tfc.show();
				lc.show();
				tfd.show();
				ld.show();
				le.show();
				tfe.show();
				lf.show();
				tff.show();
				lg.show();
				tfg.show();
			}
		});
		
		rf5=new JRadioButton("y=(ax+b)/(cx+d)");
		rf5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				la.hide();
				tfa.hide();
				lb.hide();
				tfb.hide();
				tfc.show();
				lc.show();
				tfd.show();
				ld.show();
				le.show();
				tfe.show();
				lf.show();
				tff.show();
				lg.show();
				tfg.show();
			}
		});
		
		rf1.setBounds(20, 550, 150, 30);
		rf2.setBounds(20, 580, 150, 30);
		rf3.setBounds(20, 610, 150, 30);
		rf4.setBounds(20, 640, 150, 30);
		rf5.setBounds(20, 670, 150, 30);
		bg=new ButtonGroup();
		bg.add(rf1);
		bg.add(rf2);
		bg.add(rf3);
		bg.add(rf4);
		bg.add(rf5);
		this.add(rf1);
		this.add(rf2);
		this.add(rf3);
		this.add(rf4);
		this.add(rf5);
		
		btnks=new JButton("khao sat");
		btnks.setBounds(840, 610, 100, 40);
		this.add(btnks);
		btnks.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e2) {
				// TODO Auto-generated method stub
				//ham bac 2
				if(rf1.isSelected())
				{
					str="("+tfc.getText()+")*x^2+("+tfd.getText()+")*x+("+tfe.getText()+")";
					function.add(str);
				}
				//ham bac 3
				else if(rf2.isSelected())
				{
					str="("+tfb.getText()+")*x^3+("+tfc.getText()+")*x^2+("+tfd.getText()+")*x+("+tfe.getText()+")";
					function.add(str);
				}
				//ham bac 4 trung phuong
				else if(rf3.isSelected())
				{
					str="("+tfa.getText()+")*x^4+("+tfc.getText()+")*x^2+("+tfe.getText()+")";
					function.add(str);
				}
				//bac 2 tren bac 1
				else if(rf4.isSelected())
				{
					str="(("+tfc.getText()+")*x^2+("+tfd.getText()+")*x+("+tfe.getText()+"))/(("+tff.getText()+")*x+("+tfg.getText()+"))";
					function.add(str);
				}
				//bac nhat tren bac nhat
				else if(rf5.isSelected())
				{
					str="(("+tfd.getText()+")*x+("+tfe.getText()+"))/(("+tff.getText()+")*x+("+tfg.getText()+"))";
					function.add(str);
				}
				
				//Hien phan khao sat
				String string = "";
				//bac 2
				if(rf1.isSelected())
				{
					if (c==0)
						string="ham ban nhap la ham bac nhat";
					else
					{
						string="Ham so: y="+c+"*x^2	+"+d+"*x + "+e+"\n ";
						
					}
				}
				
				
			}
		});
	}


	

}
