package com.swing.learn.ch10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Calendar;

public class TimerStopWatch {
	
	JLabel jLabel;
	JButton jButtonStart;
	JButton jButtonStop;
	
	long startTimeMs;
	
	Timer swTimer;
	
	TimerStopWatch() {
		JFrame jFrame = new JFrame("Timer-based StopWatch");
		jFrame.getContentPane().setLayout(new FlowLayout());
		jFrame.setSize(230, 90);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jLabel = new JLabel("Press start to begin timing.");
		
		jButtonStart = new JButton("Start");
		jButtonStop = new JButton("Stop");
		
		jButtonStop.setEnabled(false);
		
		ActionListener timerAl = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				updateTime();
			}
		};
		
		swTimer = new Timer(100, timerAl);
		
		jButtonStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				startTimeMs = Calendar.getInstance().getTimeInMillis();
				
				jButtonStop.setEnabled(true);
				jButtonStart.setEnabled(false);
				
				swTimer.start();
			}
		});
		
		jButtonStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				long stopTimeMs = Calendar.getInstance().getTimeInMillis();
				
				jLabel.setText("Elapsed time is " + (double) (stopTimeMs - startTimeMs) / 1000);
				
				jButtonStop.setEnabled(false);
				jButtonStart.setEnabled(true);
				
				swTimer.stop();
			}
		});
		
		jFrame.getContentPane().add(jButtonStart);
		jFrame.getContentPane().add(jButtonStop);
		jFrame.getContentPane().add(jLabel);
		
		jFrame.setVisible(true);
	}
	
	void updateTime() {
		long tempTimeMs = Calendar.getInstance().getTimeInMillis();
		jLabel.setText("Elapsed time is " + (double) (tempTimeMs - startTimeMs) / 1000);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new TimerStopWatch();
			}
		});
	}

}
