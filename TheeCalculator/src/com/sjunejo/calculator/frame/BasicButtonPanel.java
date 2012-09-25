package com.sjunejo.calculator.frame;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.sjunejo.calculator.actionlisteners.ButtonListener;

public class BasicButtonPanel extends JPanel {
	
	public BasicButtonPanel(){
		// set layout (Grid Layout)
		setLayout(new GridLayout(5,4));
		
		// add buttons
		String[] buttonArray = {"<-", "CE", "C", "+/-", "root",
				"7", "8", "9", "/", "%",
				"4", "5", "6", "*", "1/x",
				"1", "2", "3", "-", "=",
				"0", ".", "+"};
		
		
		// add action listener to each button
		for (String str: buttonArray){
			JButton btn = new JButton(str);
			btn.addActionListener(new ButtonListener());
			this.add(btn);
			
		}
	}

}
