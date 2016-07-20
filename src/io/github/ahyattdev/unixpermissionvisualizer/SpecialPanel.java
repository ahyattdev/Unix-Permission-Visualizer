package io.github.ahyattdev.unixpermissionvisualizer;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * A panel that is only used to represent the special permission octal.
 * 
 * @author Andrew Hyatt
 *
 */
public class SpecialPanel extends JPanel {
	
	/**
	 * Not sure why this is necessary.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Represents the setuid bit.
	 */
	JCheckBox setuid;
	
	/**
	 * Represents the setgid bit.
	 */
	JCheckBox setgid;
	
	/**
	 * Represents the sticky bit.
	 */
	JCheckBox stickyBit;
	
	/**
	 * Creates a <code>JPanel</code> with a border that contains three
	 * permission checkboxes which are accessible through fields of this class.
	 * 
	 * The name is inferred to be <code>Special</code>.
	 * 
	 * @param ui Used for adding an action listener for when a checkbox state changes.
	 */
	public SpecialPanel(UserInterface ui) {
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
