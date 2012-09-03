package com.sjunejo.calculator.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.sjunejo.calculator.datastructures.Datastore;
import com.sjunejo.calculator.frame.MainWindow;

public class ButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton pressedButton = (JButton) e.getSource();
		String selectedButton = pressedButton.getText();
		MainWindow mainWindow = (MainWindow) pressedButton.getTopLevelAncestor();

		// This is the most pointless change ever
		
		Datastore dataStore = mainWindow.getDataStore();
		
		// we could try casting to an int for 0 - 9..
		
		try {
			int i = Integer.parseInt(selectedButton);
			mainWindow.appendDisplay("" + i);
			
		}
		catch (NumberFormatException nfe){
			// Everything that isn't numbers
			// Might want to change to switch statement!
			
			// First, check if there's an operation waiting in the pipeline and execute it
			if (dataStore.operationWaiting()){
				dataStore.executeOperation();
			}
			
			if (selectedButton.equals("+")){
				mainWindow.resetDisplay();
				System.out.println("You hit the plus sign!");
				// Asaddasdassda what now?
			}
			
			if (selectedButton.equals("/")){ // might want to use variables to identify strings
				System.out.println("You hit the division sign!");
			}
			
			if (selectedButton.equals("-")){
				
			}
			
			if (selectedButton.equals("*")){
				
			}
			
			if (selectedButton.equals("+/-")){
				mainWindow.changePosNeg();
			}
			
			if (selectedButton.equals("root")){
				if (!(mainWindow.getDisplay() < 0)){ // awfully roundabout..
					mainWindow.setDisplay("" + Math.sqrt(mainWindow.getDisplay()));
				}
				else {
					System.out.println("Negative numbers do not have square roots!");
				}
			}
		}

	}

}
