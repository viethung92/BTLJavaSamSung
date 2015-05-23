 package baitaplon;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class graphic {
	public static myframe fm;
	public static khaosat ks;
	public static Button vdths, kshs;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		JFrame frame = new JFrame("khao sat & ve do thi");
		frame.setSize(500, 300);
		frame.setLayout(null);
		vdths = new Button("ve do thi ham so");
		vdths.setBounds(50, 50, 150, 100);
		vdths.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				fm = new myframe("ve do thi ham so");
				fm.show();

			}
		});
		frame.add(vdths);
		
		kshs = new Button("khao sat ham so");
		kshs.setBounds(250, 50, 150, 100);
		kshs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ks = new khaosat("khao sat ham so");
				ks.show();

			}
		});
		frame.add(kshs);
		frame.show();

	}

}
