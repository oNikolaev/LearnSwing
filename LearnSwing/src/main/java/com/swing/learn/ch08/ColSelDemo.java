package com.swing.learn.ch08;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class ColSelDemo {
	
	String[] headings = {"From", "Address", "Subject", "Size"};
	
	Object[][] data = {
			{"Wendy", "Wendy@HerbShildt.com", "Hello Herb", new Integer(287)},
			{"Alex", "Alex@HerbShildt.com", "Check this out!", new Integer(152)},
			{"Hale", "Hale@HerbShildt.com", "Found a bug", new Integer(315)},
			{"Todd", "Todd@HerbShildt.com", "Did you see this?", new Integer(784)},
			{"Steve", "Steve@HerbShildt.com", "I'm back", new Integer(869)},
			{"Ken", "Ken@HerbShildt.com", "Arrival time change", new Integer(754)},
	};
	
	JTable jtabEmail;
	JLabel jLab;
	
	ColSelDemo() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
