package io.github.ahyattdev.unixpermissionvisualizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class UserInterface {
	
	JFrame frame;
	
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
				SwingUtilities.copy
			}
		});
		editMenu.add(copy);
		menuBar.add(editMenu);
		
		JMenu helpMenu = new JMenu("Help");
		JMenuItem about = new JMenuItem("About Unix Permission Visualizer");
		helpMenu.add(about);
		menuBar.add(helpMenu);
		
		this.frame.setJMenuBar(menuBar);
		
		this.frame.pack();
		this.frame.setVisible(true);
	}
	
}
