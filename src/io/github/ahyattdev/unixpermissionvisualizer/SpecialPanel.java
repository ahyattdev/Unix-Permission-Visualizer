package io.github.ahyattdev.unixpermissionvisualizer;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class SpecialPanel extends JPanel {
	
	/**
	 * Not sure why this is necessary
	 */
	private static final long serialVersionUID = 1L;
	
	JCheckBox setuid, setgid, stickyBit;
	
	public SpecialPanel(JTextField display, UserInterface ui) {
		super(new GridBagLayout());
		
		String name = "Special";
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		this.setuid = new JCheckBox("setuid");
		this.setgid = new JCheckBox("setgid");
		this.stickyBit = new JCheckBox("Sticky bit");
		
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.updateField();
			}
		};
		
		this.setuid.addActionListener(al);
		this.setgid.addActionListener(al);
		this.stickyBit.addActionListener(al);
		
		c.gridy = 0;
		this.add(this.setuid, c);
		c.gridy = 1;
		this.add(this.setgid, c);
		c.gridy = 2;
		this.add(this.stickyBit, c);
		
		this.setBorder(new TitledBorder(name));
	}
	
}
