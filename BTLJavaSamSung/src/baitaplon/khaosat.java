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

public class khaosat extends JFrame{
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
	public JLabel ly,la,lb,lc,ld,lf,lg; //lg la dau gach ngang phan so trong truong hop ham la phan so
	public JTextField tfa,tfb,tfc,tfd,tfe,tff,tfg;
	public JTextArea te;
	public JButton btnks,btncancle;
	public khaosat ks;
	public Thread t;
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
	public khaosat(String s)
	{
		super(s);
		this.setSize(1300,740);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ks=this;
		function=new ArrayList<>();
		
		ly=new JLabel("y=");
		ly.setBounds(300, 610, 30, 30);
		this.add(ly);
		la=new JLabel("x^4+");
		la.setBounds(360, 570, 30, 30);
		this.add(la);
		la.hide();
		lb=new JLabel("x^3+");
		lb.setBounds(420, 570, 30, 30);
		this.add(lb);
		lb.hide();
		lc=new JLabel("x^2+");
		lc.setBounds(480, 570, 30, 30);
		this.add(lc);
		lc.hide();
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
		tfa.setBounds(330, 570, 30, 30);
		this.add(tfa);
		tfa.hide();
		tfa.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				a=Float.parseFloat(tfa.getText());
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				
			}
		});
		
		tfb=new JTextField();
		tfb.setBounds(390, 570, 30, 30);
		this.add(tfb);
		tfb.hide();
		tfb.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				b=Float.parseFloat(tfb.getText());
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		tfc=new JTextField();
		tfc.setBounds(450, 570, 30, 30);
		this.add(tfc);
		tfc.hide();
		tfc.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				c=Float.parseFloat(tfc.getText());
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		tfd=new JTextField();
		tfd.setBounds(510, 570, 30, 30);
		this.add(tfd);
		tfd.hide();
		tfd.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				d=Float.parseFloat(tfd.getText());
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		tfe=new JTextField();
		tfe.setBounds(570, 570, 30, 30);
		this.add(tfe);
		tfe.hide();
		tfe.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e1) {
				// TODO Auto-generated method stub
				e=Float.parseFloat(tfe.getText());
			}
			
			@Override
			public void focusGained(FocusEvent e1) {
				// TODO Auto-generated method stub
				
			}
		});
		
		tff=new JTextField();
		tff.setBounds(330, 640, 30, 30);
		this.add(tff);
		tff.hide();
		tff.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				f=Float.parseFloat(tff.getText());
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		tfg=new JTextField();
		tfg.setBounds(390, 640, 30, 30);
		this.add(tfg);
		tfg.hide();
		tfg.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				g=Float.parseFloat(tfg.getText());
			}
			
			@Override
			public void focusGained(FocusEvent e) {
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
				la.hide();
				tfa.hide();
				lb.hide();
				tfb.hide();
				tfc.show();
				lc.show();
				tfd.show();
				ld.show();
				//le.show();
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
			public void actionPerformed(ActionEvent e) {
				la.hide();
				tfa.hide();
				lb.show();
				tfb.show();
				tfc.show();
				lc.show();
				tfd.show();
				ld.show();
				//le.show();
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
			public void actionPerformed(ActionEvent e) {
				la.show();
				tfa.show();
				lb.hide();
				tfb.hide();
				tfc.show();
				lc.show();
				tfd.hide();
				ld.hide();;
				//le.show();
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
			public void actionPerformed(ActionEvent e) {
				la.hide();
				tfa.hide();
				lb.hide();
				tfb.hide();
				tfc.show();
				lc.show();
				tfd.show();
				ld.show();
				//le.show();
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
			public void actionPerformed(ActionEvent e) {
				la.hide();
				tfa.hide();
				lb.hide();
				tfb.hide();
				tfc.hide();
				lc.hide();
				tfd.show();
				ld.show();
				//le.show();
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
				//ham bac 2
				if(rf1.isSelected())
				{
					str="("+tfc.getText()+")*x^2+("+tfd.getText()+")*x+("+tfe.getText()+")";
					function.add(str);
					//System.out.println(str);
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
				//hien phan khao sat
				String string = "";
				//bac 2
				if(rf1.isSelected())
				{
					if (c==0)
						   string="ham ban nhap la ham bac nhat";
					else
					   {
					       string="Ham so:  y= "+c+"*x^2  +"+d+"*x+ "+e+"\n ";   // 	GO DEN DAY ROI
					       //tap xac dinh
						   string+=" 1)  Tap xac dinh:\n      D=R\n";
						   //dao ham
						   string+=" 2)  Dao ham bac nhat: \n      y'="+ 2*c+"*x  +"+d+"\n";
						   //cuc tri va bien thien
						   float a2 =-d/(2*c);// toa do x cua cuc tri
						   float y;			//toa do y cua cuc tri
						   y=c*(a2)*(a2)+d*(a2)+e;
					       if (c>0)
						   {
							    string+=" 3)  Diem cuc tieu la nghiem cua phuong trinh: y'=0\n        => la diem A("+a2+","+ y+")\n";
								string+=" 4)  Khoang dong bien va nghich bien:\n      Nghich bien tren khoang (-vo cung, "+a2+")\n      Dong bien tren khoang     ("+a2+",+vocung)";
						   }
						   if (c<0)
						   {
							    string+=" 3)  Diem cuc dai la nghiem cua phuong trinh: y'=0\n        => la diem A("+a2+","+ y+")\n";
								string+=" 4)  Khoang dong bien va nghich bien:\n      Dong bien tren khoang     ("+a2+",+vo cung)\n      Nghich bien tren khoang (-vo cung, "+a2+")\n";
						   }
					   }
				}
				//ham bac 3
				else if(rf2.isSelected())
				{
				   if (b==0)
					   string="ban da chon sai kieu ham so.de nghi ban chon ham 1 de co ket qua khao sat";
				   
				   else
				   {
					   string="                 Ham so:  y= "+b+"*x^3  +"+c+"x^2 +"+d+"*x +"+e+"\n";
				       //tap xac dinh
					   string+="1) Tap xac dinh:\n    D=R\n";
					   //dao ham
					   string+="2) Dao ham:\n    y'="+3*b+"x^2 + "+2*c+"x + "+d+"\n";
					   string+="    y''="+6*b+"x + "+2*c+"\n";
					   //cuc tri
					   string+="3)Cuc tri:\n";
				       double dd,x1,x2,y1;
						   dd=c*c-3*b*d; //delta' cua dao ham bac nhat
				           x1=(-c+Math.sqrt(dd))/(3*b); //nghiem x1>x2
						   x2=(-c-Math.sqrt(dd))/(3*b);
						   y1=6*b*x1+2*c;   //neu y2<0 thi x1 la do thi loi,nguoc lai la lom
						   String str1,str2,str3,str4;
					   if (dd<=0)
					   {
						   string+="Ham so khong co cuc tri\n";
					   }
					   else
					   {
						   if (y1<0)
						   {
							   str1=""+x1;
							   str2=""+b*x1*x1*x1+c*x1*x1+d*x1+e;
							   str3=""+x2;
							   str4=""+b*x2*x2*x2+c*x2*x2+d*x2+e;
						   }
						   else
						   {
							   str3=""+x1;
							   str4=""+b*x1*x1*x1+c*x1*x1+d*x1+e;
							   str1=""+x2;
							   str2=""+b*x2*x2*x2+c*x2*x2+d*x2+e;
						   }
						   string+="Ham so co 2 cuc tri la:\n";
						   string+="Cuc dai la diem A("+str1+","+str2+")   Cuc tieu la diem B("+str3+","+str4+")\n";
					   }
					   //diem uon
					   double a2=-c/(3*b); //toa do x cua diem uon
				       double y;			//toa do y cua diem uon
					   y=b*(a2)*(a2)*(a2)+c*(a2)*(a2)+d*(a2)+e;
					   string+="4) Diem uon la nghiem cua phuong trinh y''=0:\n     diem uon U("+a2+","+y+")\n";
					   //khoang bien thien
					   string+="5) Khoang bien thien:\n";
					   if(dd>0)  //ne co cuc tri
					   {
					     if (b>0)
						 {
						   string+="     Ham so dong bien tren: (-vo cung,"+x2+") hop voi ("+x1+",+vo cung)\n";
						   string+="     Ham so nghich bien tren: ("+x2+","+x1+")\n";
						 }
					     else
						 {
						   string+="     Ham so nghich bien tren: (-vo cung,"+x2+") hop voi ("+x1+",+vo cung)\n";
						   string+="     Ham so dong bien tren: ("+x2+","+x1+")\n";
						 }
					   }
					   else	//neu k co cuc tri
					   {
						   if (b>0)
							   string+=" Ham so dong bien tren R\n";
						   else
							   string+=" Ham so nghich bien tren R\n";
					   }
			   		}
				}

				//ham bac 4 trung phuong
				else if(rf3.isSelected())
				{
					   String str1,str2;
					   if (a==0)
						   string="ban da chon sai kieu ham so.de nghi ban chon ham 1 de co ket qua khao sat";
					   else
					   {
					   string="                 Ham so:  y= "+a+"*x^4  +"+c+"x^2 +"+e+"\n";
				       //txd
					   string+="1) Tap xac dinh:\n    D=R\n";
					   //dao ham
					   string+="2) Dao ham:\n    y'="+4*a+"x^3 + "+2*c+"x \n";
					   string+="    y''="+12*a+"x^2 + "+2*c+"\n";
					   //cuc tri va diem uon
					   string+="3)Cuc tri:\n";
					   if ((-c/(2*a))<=0)
					   {
						   string+="Ham so co 1 cuc tri";
						    if(a>0)
							{
								string+= " la cuc tieu    A(0,"+e+")\n";
							}
							else
							{
								string+= " la cuc dai    A(0,"+e+")\n";
							}
							string+="4) Diem uon la nghiem cua phuong trinh y''=0 \n         => Ham so khong co diem uon\n";
					   }
					   else
					   {
						   string+="Ham so co 3 cuc tri.\n";
						   double dd,x1;
						   x1=-Math.sqrt(-c/(2*a));
						   if (a<0)
						   {
							  str1="dai";
							  str2="tieu";
						   }
						   else
						   {
							  str1="tieu";
							  str2="dai";
						   }
						   string+="Cuc "+str1+" la diem A("+x1+","+(a*x1*x1*x1*x1+c*x1*x1+e)+")   va diem B("+(-x1)+","+(a*x1*x1*x1*x1+c*x1*x1+e)+")\n";
						   string+="Cuc "+str2+" la diem C(0,"+e+")\n";
						   string+="4) Diem uon la nghiem cua phuong trinh y''=0 \n        => Ham so co 2 diem uon la:\n";
				           x1=Math.sqrt(-c/(6*a));
						   string+="        diem U1("+x1+","+a*x1*x1*x1*x1+c*x1*x1+e+")      va U2("+-x1+","+a*x1*x1*x1*x1+b*x1*x1+c+")\n";

					   }
					   //khoang bien thien
					   string+="5) Khoang bien thien:\n";
					   if((-c/(2*a))<0)
					   {
					     if (a>0)
						 {
						   string+="     Ham so nghich bien tren: (-vo cung,0)\n     Ham so dong bien tren (0,+vo cung)\n";		   
						 }
					     else
						 {
						   string+="     Ham so dong bien tren: (-vo cung,0)\n     Ham so nghich bien tren (0,+vo cung)\n"; 
						 }
					   }
					   else
					   {
						   double x1;
						   x1=-Math.sqrt(-b/(2*a));
						   if (a>0)
						   {
							   str1="nghich";
							   str2="dong";
						   }
						   else
						   {	
							   str1="dong";
							   str2="nghich";
						   }
						   string+="     Ham so "+str1+" bien tren (-vo cung,"+x1+") va (0,"+-x1+")\n";
						   string+="     Ham so "+str2+" bien tren ("+x1+",0)  va ("+-x1+",+vo cung)\n";
					   }
					}
				}
				//ham bac 2 tren bac nhat
				else if(rf4.isSelected())
				{
					String str1,str2,str3,str4;
					if(c==0)
					   {
						if ((d*g-e*f)==0)
						   {
							   string="ham so bi suy bien thanh ham hang \n  y="+d/f+"\n";
						   }
						   else
							   string+="ham so bi suy bien thanh ham bac 1 tren bac nhat,\nde nghi ban chon ham bac 1 tren bac 1 de co ket qua dung\n";
					   }
					   else 
					   {
					      if(e==0)
						  {
						   string+="ham so bi suy bien thanh ham bac 2,de nghi ban chon ham 2 de co ket qua dung\n";
						  }
					      else
						  {
						    if((c*g*g-f*d*g+e*f*f)==0)
							{
				                string+="ham so bi suy bien thanh ham 1:\r\n y="+c/f+"x + "+(d/f-c*g/f/f)+",de nghi ban chon ham 1 de co ket qua dung\n";
							}
							else
				            {
								string="    y=("+c+"x^2 + "+d+"x + "+e+")/("+f+"x + "+g+")\n";
							   //tap xac dinh
								string+="1) Tap xac dinh:  D=R|{"+-g/f+"}\r\n";
								//dao ham
								string+="2) Dao ham:\r\n     y'=("+c*f+"*x^2 + "+2*c*g+"*x + "+(d*g-e*f)+")/("+f+"*x + "+g+")^2\n";
								//tiem can
								string+="3) Tiem can:\r\n   ham so y=f(x) co the phan tich thanh\r\n     y="+c/f+"x + "+(d/f-c*g/(f*f))+"+ "+(e-d*g/f+c*g*g/(f*f))+"/("+f+"x + "+g+")\n";
								string+="   => Do thi ham so co tiem can xien la duong thang y="+c/f+"*x + "+(d/f-c*g/(f*f))+"\n";
								string+="   Do thi ham so co tiem can dung la duong thang x="+-f/e+"\n";
								//cuc tri
								string+="4) Cuc tri:\n";
								float dt,x1 = 0,x2 = 0,y1,y2;
								dt=(c*c*g*g)-c*f*(d*g-e*f);//delta' cua tu so dao ham
								
								if (dt>0)
								{
									//float a1,a2,b1,b2;
									x1=(float) ((-c*g-Math.sqrt(dt))/(c*f));
									x2=(float) ((-c*g+Math.sqrt(dt))/(c*f));
									y1=(c*x1*x1+d*x1+e)/(f*x1+g);
									y2=(c*x2*x2+d*x2+e)/(f*x2+g);
									if(x1>x2)
									{
										float tg;
										tg=x2;
										x2=x1;
										x1=tg;
										tg=y2;
										y2=y1;
										y1=tg;
									}
									if (y1<y2)
									{
										str1=x1+"";
										str2=y1+"";
										str3=x2+"";
										str4=y2+"";
									}
									else
									{
										str3=x1+"";
										str4=y1+"";
										str1=x2+"";
										str2=y2+"";
									}
								    string+="Do thi ham so co 2 cuc tri la:\r\n   Diem cuc dai la A("+str1+","+str2+")   cuc tieu la B("+str3+","+str4+")\n";
								}
								else
								{
									string+="Ham so khong co cuc tri\n";  //GO DEN DAY
								}
								 //bien thien
								str1=x1+"";
								str2=-g/f+"";
								str3=x2+"";
								string+="5) Bien thien:\n";
								if (dt>0)
								{
									if ((c/f)>0)
									{
										string+="   Ham so dong bien tren (-vo cung,"+str1+") va ("+str3+",+vo cung)\n";
										string+="   Ham so nghich bien tren ("+str1+","+str2+") va ("+str2+","+str3+")\n";
									}
									else
									{		   
										string+="   Ham so nghich bien tren (-vo cung,"+str1+") va ("+str3+",+vo cung)\r\n";
										string+="   Ham so dong bien tren ("+str1+","+str2+") va ("+str2+","+str3+")\r\n";
									}
								}
								else
								{
									if ((c/f)>0)
									{
									    string+="   Ham so dong bien tren tap xac dinh D\n";
									} 
						            else
									{		   
										string+="   Ham so nghich bien tren tap xac dinh D\n";
									}
								}
							}
						  }
					   }
				}
				//ham bac nhat tren bac nhat
				else if(rf5.isSelected())
				{
					   if ((d*g-e*f)==0)
					   {
						   string="ham so bi suy bien thanh ham hang \r\n  y="+d/f+"\n";
					   }
					   else
					   {	   string="       y=("+d+"x + "+e+")/("+f+"x + "+g+")\n";
					   //txd
					   string+="1) Tap xac dinh:    D=R|{"+-g/f+"}\n";
					   //dao ham
					   string+="2) Dao ham:\n    y'="+(d*g-e*f)+"/("+f+"x + "+g+")^2\n";
					   //tiem can
					   string+="3) Tiem can:\n";
					   string+="   Tiem can ngang la duong thang: y="+d/f+"\r\n";
					   string+="   Tiem can dung la duong thang:  x="+-g/f+"\r\n";
					   //khoang bien thien
					  if ((d*g-e*f)<0)
						  string+="4) Khoang bien thien:\r\n    Ham so nghich bien tren Tap xac dinh D\r\n";
					  else
						  string+="4) Khoang bien thien:\r\n    Ham so dong bien tren Tap xac dinh D\r\n";
					   }
				}
				te.setText(string);
			}
		});
		btncancle=new JButton("huy");
		btncancle.setBounds(950, 610, 100, 40);
		this.add(btncancle);
		btncancle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				del=true;
				te.setText("");
			}
		});
		
		t=new Thread(new Runnable() {
			
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
					//	tttx.setText(String.valueOf(this.getx()/30-10));
						//ttty.setText(String.valueOf(-this.gety()/30+10));
					}
					
				};
				mp.setBounds(30, 30, 600, 500);
				mp.setBackground(Color.white);
				ks.add(mp);
				mp.setcolor(Color.black);//dat mau mac dinh khi ve do thi
				while (true)
				{
//					 int scalex=30;
//					 int scaley=30;
//					 int ox=300;
//					 int oy=300;
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
