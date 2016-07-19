package io.github.ahyattdev.unixpermissionvisualizer;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PermissionPanel extends JPanel {

	/**
	 * Not sure why this is necessary
	 */
	private static final long serialVersionUID = 1L;
	
	JCheckBox read, write, execute;
	
	public PermissionPanel(JTextField display, UserInterface ui, String name) {
		super(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		this.read = new JCheckBox("Read");
		this.write = new JCheckBox("Write");
		this.execute = new JCheckBox("Execute");
		
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.updateField();
			}
		};
		
		this.read.addActionListener(al);
		this.write.addActionListener(al);
		this.execute.addActionListener(al);
		
		c.gridy = 0;
		this.add(this.read, c);
		c.gridy = 1;
		this.add(this.write, c);
		c.gridy = 2;
		this.add(this.execute, c);
		
		this.setBorder(new TitledBorder(name));
	}

}
