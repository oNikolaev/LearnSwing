package com.swing.learn.ch10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Calendar;

public class ThreadStopWatch {
	
	JLabel jLabel;
	
	JButton jButtonStart;
	JButton jButtonStop;
	
	long start;
	
	boolean isRunning = false;
	
	Thread thread;
	
	ThreadStopWatch() {
		
		JFrame jFrame = new JFrame("Thread-based stop watch");
		
		jFrame.getContentPane().setLayout(new FlowLayout());
		jFrame.setSize(230, 90);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jLabel = new JLabel("Press start to begin timing");
		
		jButtonStart = new JButton("Start");
		jButtonStop = new JButton("Stop");
		
		jButtonStop.setEnabled(false);
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				try {
					for(;;) {
						Thread.sleep(100);
						
						SwingUtilities.invokeLater(new Runnable() {
							
							@Override
							public void run() {
								updateTime();
							}
						});
					}
				}
				catch(InterruptedException exc) {
					System.out.println("Call to sleep was interrupted.");
					System.exit(1);
				}
			}
		};
		
		thread = new Thread();
		thread.start();
		
		jButtonStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				start = Calendar.getInstance().getTimeInMillis();
				
				jButtonStop.setEnabled(true);
				jButtonStart.setEnabled(false);
				
				isRunning = true;
			}
		});
		
		jButtonStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				long stop = Calendar.getInstance().getTimeInMillis();
				
				jLabel.setText("Elapsed time is " + (double) (stop - start) / 1000);
				
				jButtonStart.setEnabled(true);
				jButtonStop.setEnabled(false);
				
				isRunning = false;
			}
		});
		
		jFrame.getContentPane().add(jButtonStart);
		jFrame.getContentPane().add(jButtonStop);
		jFrame.getContentPane().add(jLabel);
		
		jFrame.setVisible(true);
	}
	
	void updateTime() {
		
		if (!isRunning) {
			return;
		}
		
		long temp = Calendar.getInstance().getTimeInMillis();
		jLabel.setText("Elapsed time is " + (double) (temp - start) / 1000);
	}
	
	public static void main(String args[]) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new ThreadStopWatch();
			}
		});
		
	}
}
