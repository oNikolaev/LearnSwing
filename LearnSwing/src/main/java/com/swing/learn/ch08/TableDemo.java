package com.swing.learn.ch08;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class TableDemo {
	String[] headings = {"From","Address","Subject","Size"};
	
	Object[][] data = {
			{"Wendy", "Wendy@HerbShildt.com", "Hello Herb", new Integer(287)},
			{"Alex", "Alex@HerbShildt.com", "Check this out!", new Integer(152)},
			{"Hale", "Hale@HerbShildt.com", "Found a bug", new Integer(315)},
			{"Todd", "Todd@HerbShildt.com", "Did you see this?", new Integer(784)},
			{"Steve", "Steve@HerbShildt.com", "I'm back", new Integer(869)},
			{"Ken", "Ken@HerbShildt.com", "Arrival time change", new Integer(754)},
	};
	
	JTable jTabEmail;
	
	TableDemo() {
		JFrame jfrm = new JFrame("Simple Table Demo");
		
		jfrm.getContentPane().setLayout(new FlowLayout());
		jfrm.setSize(500, 160);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jTabEmail = new JTable(data, headings);
		
		JScrollPane jScrollPane = new JScrollPane(jTabEmail);
		
		jTabEmail.setPreferredScrollableViewportSize(new Dimension(450, 80));
		jTabEmail.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//jTabEmail.setColumnSelectionAllowed(true);
		//jTabEmail.setRowSelectionAllowed(false);
		jTabEmail.setCellSelectionEnabled(true);
		
		jfrm.getContentPane().add(jScrollPane);
		jfrm.setVisible(true);		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new TableDemo();
			}
		});
	}
}
