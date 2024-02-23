package com.swing.learn.ch01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class StopWatch implements ActionListener {
	
	JLabel jLabel;
	long start;
	
	public StopWatch() {
		JFrame jFrame = new JFrame("A simple Stopwatch");
		
		jFrame.getContentPane().setLayout(new FlowLayout());
		jFrame.setSize(230, 90);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton jbtnStart = new JButton("Start");
		JButton jbtnStop = new JButton("Stop");
		
		jbtnStart.addActionListener(this);
		jbtnStop.addActionListener(this);
		
		jFrame.getContentPane().add(jbtnStart);
		jFrame.getContentPane().add(jbtnStop);
		
		jLabel = new JLabel("Press start to begin timing");
		jFrame.getContentPane().add(jLabel);
		jFrame.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Calendar cal = Calendar.getInstance();
		
		if (ae.getActionCommand().equals("Start")) {
			start = cal.getTimeInMillis();
			jLabel.setText("Stopwatch is running...");
		}
		else
			jLabel.setText("Elapsed time is " + (double)(cal.getTimeInMillis() - start)/1000);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new StopWatch();
			}
		});
	}
	
}
