package io.github.ahyattdev.unixpermissionvisualizer;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The class responsible for creating the GUI.
 * 
 * @author Andrew Hyatt
 *
 */
public class UserInterface {
	
	/**
	 * The main <code>JFrame</code>.
	 * It is <code>null</code> until {@link #createAndShowGUI()} is called.
	 */
	JFrame frame;
	
	/**
	 * The <code>JTextfield</code> responsible for displaying the 4 permission octals.
	 */
	JTextField display;
	
	/**
	 * A <code>JPanel</code> representing the special permission octal.
	 */
	SpecialPanel special;
	
	/**
	 * A <code>JPanel</code> representing the user permission octal. 
	 */
	PermissionPanel user;
	
	/**
	 * A <code>JPanel</code> representing the group permission octal.
	 */
	PermissionPanel group;
	
	/**
	 * A <code>JPanel</code> representing the other permission octal.
	 */
	PermissionPanel other;
	
	/**
	 * Creates and displays the main <code>JFrame</code>.
	 * 
	 * @see SpecialPanel
	 * @see PermissionPanel
	 */
	public void createAndShowGUI() {
		this.frame = new JFrame("Unix Permission Visualizer");
		this.frame.setResizable(false);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});
		fileMenu.add(exit);
		menuBar.add(fileMenu);
		
		JMenu helpMenu = new JMenu("Help");
		JMenuItem about = new JMenuItem("About Unix Permission Visualizer");
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, Main.description);
			}
		});
		helpMenu.add(about);
		menuBar.add(helpMenu);
		
		this.frame.setJMenuBar(menuBar);
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		this.special = new SpecialPanel(this);
		this.user = new PermissionPanel(this, "User");
		this.group = new PermissionPanel(this, "Group");
		this.other = new PermissionPanel(this, "Other");
		
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx = 0;
		panel.add(this.special, c);
		
		c.gridx = 1;
		panel.add(this.user, c);
		
		c.gridx = 2;
		panel.add(this.group, c);
		
		c.gridx = 3;
		panel.add(this.other, c);

		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 4;
		
		JPanel displayPanel = new JPanel(new FlowLayout());
		
		this.display = new JTextField("0000");
		Font font = new Font(this.display.getFont().getName(), Font.BOLD, 18);
		this.display.setFont(font);
		displayPanel.add(this.display);
		panel.add(displayPanel, c);
		
		this.frame.add(panel);
		
		this.frame.pack();
		
		this.frame.setLocationRelativeTo(null);
		
		this.frame.setVisible(true);
	}
	
	/**
	 * Creates the four Unix permission octals from the checkboxes
	 * and puts them in an array.
	 * 
	 * @return An int array with four elements.
	 * The first is the special octal, second is the user octal, third is the group octal
	 * and fourth is the other octal.
	 * 
	 * @see PermissionPanel
	 * @see SpecialPanel
	 */
	int[] getNumbers() {
		int special = 0;
		int user = 0;
		int group = 0;
		int other = 0;
		
		if (this.special.setuid.isSelected()) special += 4;
		if (this.special.setgid.isSelected()) special += 2;
		if (this.special.stickyBit.isSelected()) special += 1;
		
		if (this.user.read.isSelected()) user += 4;
		if (this.user.write.isSelected()) user += 2;
		if (this.user.execute.isSelected()) user += 1;
		
		if (this.group.read.isSelected()) group += 4;
		if (this.group.write.isSelected()) group += 2;
		if (this.group.execute.isSelected()) group += 1;
		
		if (this.other.read.isSelected()) other += 4;
		if (this.other.write.isSelected()) other += 2;
		if (this.other.execute.isSelected()) other += 1;
		
		int[] numbers = { special, user, group, other };
		return numbers;
	}
	
	/**
	 * Combines the four elements of the array returned by <code>getNumbers()</code>
	 * into <code>String</code> that is suitable for presenting to the user.
	 * 
	 * @return A string that is suitable for presenting to the user.
	 */
	String getStringRep() {
		int[] numbers = getNumbers();
		String s = "";
		for (int n : numbers) {
			s += n;
		}
		return s;
	}
	
	/**
	 * Updates the contents of {@link #display} with contents that is generated from
	 * the checkboxes.
	 */
	void updateField() {
		this.display.setText(getStringRep());
	}
	
}
