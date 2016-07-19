package io.github.ahyattdev.unixpermissionvisualizer;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
	
	static UserInterface ui;
	
	public static void main(String[] args) {
        ui = new UserInterface();
        
	    try {
	    	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        	e.printStackTrace();
        }
	    
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		        ui.createAndShowGUI();
		    }
		});
	}

}
