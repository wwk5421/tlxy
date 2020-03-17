package com.zhang.ui;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.zhang.utils.DateUtils;

public class MyFrame extends JFrame {
	
	private static final long serialVersionUID = 1565487728296800903L;

	public MyFrame() {
		super();
		
		System.out.println(getLayout());
//		setLayout(getLayout());
		
		FlowLayout fl = new FlowLayout();
		setLayout(fl);
		
		JButton b1 = new JButton("b1");
		JButton b2 = new JButton("b2");
		
		JPanel p = new JPanel();
		p.setName(DateUtils.getCurrentDateStr());
		
		p.add(b1);
		p.add(b2);
		
		add(p);
		
		b1.addKeyListener(new ButtonKeyListener());
		
		
		
		int width = 100;
		int height = 100;
		setBounds(100, 100, width, height);
		
		setVisible(true);
	}
}

class ButtonKeyListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		System.out.println(arg0);
		
	}
	
}
