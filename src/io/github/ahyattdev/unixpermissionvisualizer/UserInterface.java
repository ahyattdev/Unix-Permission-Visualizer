package io.github.ahyattdev.unixpermissionvisualizer;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserInterface {
	
	JFrame frame;
	JTextField display;
	
	PermissionPanel user, group, other;
	
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
		
		JMenu editMenu = new JMenu("Edit");
		JMenuItem copy = new JMenuItem("Copy");
		copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		editMenu.add(copy);
		menuBar.add(editMenu);
		
		JMenu helpMenu = new JMenu("Help");
		JMenuItem about = new JMenuItem("About Unix Permission Visualizer");
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		helpMenu.add(about);
		menuBar.add(helpMenu);
		
		this.frame.setJMenuBar(menuBar);
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		this.user = new PermissionPanel("User");
		this.group = new PermissionPanel("Group");
		this.other = new PermissionPanel("Other");
		
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx = 0;
		panel.add(user, c);
		
		c.gridx = 1;
		panel.add(group, c);
		
		c.gridx = 2;
		panel.add(other, c);
		
		this.frame.add(panel);
		
		this.frame.pack();
		this.frame.setVisible(true);
	}
	
}
