package com.swing.learn.ch08;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class RowSelDemo {
	
	String[] headings = {"From", "Address", "Subject", "Size"};
	
	Object[][] data = {
			{"Wendy", "Wendy@HerbShildt.com", "Hello Herb", new Integer(287)},
			{"Alex", "Alex@HerbShildt.com", "Check this out!", new Integer(152)},
			{"Hale", "Hale@HerbShildt.com", "Found a bug", new Integer(315)},
			{"Todd", "Todd@HerbShildt.com", "Did you see this?", new Integer(784)},
			{"Steve", "Steve@HerbShildt.com", "I'm back", new Integer(869)},
			{"Ken", "Ken@HerbShildt.com", "Arrival time change", new Integer(754)},
	};
	
	JTable jTabEmail;
	JLabel jLab;
	
	public RowSelDemo() {
		JFrame jfrm = new JFrame("Row Selection Demo");
		
		jfrm.getContentPane().setLayout(new FlowLayout());
		jfrm.setSize(500, 200);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jLab = new JLabel();
		
		jTabEmail = new JTable(data, headings);
		JScrollPane jScrollPane = new JScrollPane(jTabEmail);
		
		jTabEmail.setPreferredScrollableViewportSize(new Dimension(450, 80));
		
		ListSelectionModel lsmRow = jTabEmail.getSelectionModel();
		
		lsmRow.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent le) {
				String str = "Selected Rows: ";
				
				int[] rows = jTabEmail.getSelectedRows();
				
				for (int i=0; i < rows.length; i++) {
					str += rows[i] + " ";
				}
				
				jLab.setText(str);
			}
			
		});
		
		jfrm.getContentPane().add(jScrollPane);
		jfrm.getContentPane().add(jLab);
		jfrm.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new RowSelDemo();
			}
		});
	}

}
