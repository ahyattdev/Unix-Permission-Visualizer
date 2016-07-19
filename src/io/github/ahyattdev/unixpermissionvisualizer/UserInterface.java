package io.github.ahyattdev.unixpermissionvisualizer;

import java.awt.Dimension;
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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserInterface {
	
	JFrame frame;
	JTextField display;
	
	SpecialPanel special;
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
		
		this.special = new SpecialPanel();
		this.user = new PermissionPanel("User");
		this.group = new PermissionPanel("Group");
		this.other = new PermissionPanel("Other");
		
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
		this.frame.setVisible(true);
	}
	
}
