package com.sjunejo.calculator.frame;

import java.awt.BorderLayout;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sjunejo.calculator.datastructures.Datastore;

public class MainWindow extends JFrame {
	
	private JTextField jtfDisplay;
	private Stack mainStack;
	private boolean isPositive;
	private Datastore dataStore;
	
	public MainWindow(){
		setSize(480, 320);
		setTitle("Thee Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		
		setTopPanel();
		setMiddlePanel();
		
		dataStore = new Datastore();
		isPositive= true;
		
		pack();
		setVisible(true);
	}
	
	void setTopPanel(){
		JPanel pTop = new JPanel();
		
		jtfDisplay = new JTextField(15);
		jtfDisplay.setEditable(false);
		jtfDisplay.setSize(getSize());
		jtfDisplay.setText("0");
		pTop.add(jtfDisplay);
		
		add(pTop, BorderLayout.NORTH);
		
	}
	
	void setMiddlePanel(){
		JPanel pMiddle = new JPanel();
		pMiddle.add(new BasicButtonPanel(), BorderLayout.CENTER);
		
		add(pMiddle, BorderLayout.CENTER);
	}
	
	public void appendDisplay(String str){
		if (jtfDisplay.getText().equals("0")){
			jtfDisplay.setText(str);
		}
		else {
			jtfDisplay.setText(jtfDisplay.getText()+str);
		}
	}
	
	public void setDisplay(String str){
		jtfDisplay.setText(str);
	}
	public void resetDisplay(){
		jtfDisplay.setText("0");
	}
	
	public int getDisplay(){
		return Integer.parseInt(jtfDisplay.getText());
	}
	
	public Datastore getDataStore(){
		return dataStore;
	}
	
	// invoked when the +/- sign is hit
	public void changePosNeg(){
		if (!jtfDisplay.getText().equals("0")){ // because there is no such thing as -0...I think
			if (isPositive){
				jtfDisplay.setText("-" + jtfDisplay.getText());
				isPositive=false;
			}
			else {
				jtfDisplay.setText(jtfDisplay.getText().substring(1,jtfDisplay.getText().length()));
				isPositive=true;
			}
		}
		
	}

}
