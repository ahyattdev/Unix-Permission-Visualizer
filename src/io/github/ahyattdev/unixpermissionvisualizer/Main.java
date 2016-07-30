package io.github.ahyattdev.unixpermissionvisualizer;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * The main class of the program.
 * 
 * @author Andrew Hyatt
 *
 */
public class Main {
	
	/**
	 * Used in the About Unix Permission Visualizer dialog.
	 */
	static final String description = "Unix Permission Visualizer\n\n"
			+ "Provides a GUI for visualizing UNIX permission octals.\n\n"
			+ "Created by Andrew Hyatt <ahyattdev@icloud.com>\n\n"
			+ "The source code is available on GitHub:\n\n"
			+ "https://github.com/ahyattdev/Unix-Permission-Visualizer";
	
	/**
	 * Used to keep track of the UserInterface instance.
	 * Could be expanded to allow running multiple instances,
	 * but the same result can be achieved by creating new instances
	 * of this program.
	 */
	static UserInterface ui;
	
	/**
	 * Configures the Java GUI and instantiates UserInterface.
	 * @param args The arguments the program is launched with. Currently Unused.
	 */
	public static void main(String[] args) {
    	System.setProperty("apple.laf.useScreenMenuBar", "true");
    	System.setProperty("apple.awt.application.name", "Unix Permission Visualizer");
    	
        ui = new UserInterface();
        
	    try {
	    	// Standard normalizations
	    	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        	e.printStackTrace();
        }
	    
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		    	// Launches the GUI
		        ui.createAndShowGUI();
		    }
		});
	}

}
