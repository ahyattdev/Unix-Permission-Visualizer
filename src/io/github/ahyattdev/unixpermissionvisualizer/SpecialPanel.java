package io.github.ahyattdev.unixpermissionvisualizer;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class SpecialPanel extends JPanel {
	
	/**
	 * Not sure why this is necessary
	 */
	private static final long serialVersionUID = 1L;
	
	JCheckBox setuid, setgid, stickyBit;
	
	public SpecialPanel() {
		super(new GridBagLayout());
		
		String name = "Special";
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		this.setuid = new JCheckBox("setuid");
		this.setgid = new JCheckBox("setgid");
		this.stickyBit = new JCheckBox("Sticky bit");
		
		c.gridy = 0;
		this.add(this.setuid, c);
		c.gridy = 1;
		this.add(this.setgid, c);
		c.gridy = 2;
		this.add(this.stickyBit, c);
		
		this.setBorder(new TitledBorder(name));
	}
	
}
