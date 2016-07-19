package io.github.ahyattdev.unixpermissionvisualizer;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PermissionPanel extends JPanel {

	/**
	 * Not sure why this is necessary
	 */
	private static final long serialVersionUID = 1L;
	
	JCheckBox read, write, execute;
	
	public PermissionPanel(String name) {
		super(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		this.read = new JCheckBox("Read");
		this.write = new JCheckBox("Write");
		this.execute = new JCheckBox("Execute");
		
		c.gridy = 0;
		this.add(this.read, c);
		c.gridy = 1;
		this.add(this.write, c);
		c.gridy = 2;
		this.add(this.execute, c);
		
		this.setBorder(new TitledBorder(name));
	}

}
