package com.cts.cda.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ContactDialog extends JDialog {

	JLabel lTitle;
	JLabel lName;
	JTextField tfName;
	JComboBox<String> cbTitle;
	JButton btnOk;
	JButton btnCancel;

	public ContactDialog() {
		this.setTitle("Contact Details");
		this.setBounds(50, 50, 500, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);

		lTitle = new JLabel("Title");
		lName = new JLabel("Name");
		tfName = new JTextField();
		cbTitle = new JComboBox<String>(new String[] { "Mr.", "Mrs.", "Dr.", "Prof.", "Master.", "Baby." });
		btnOk = new JButton("OK");
		btnCancel = new JButton("Cancel");

		this.add(lTitle, 20, 20, 150, 25);
		this.add(cbTitle, 20, 50, 150, 25);
		this.add(lName, 180, 20, 150, 25);
		this.add(tfName, 180, 50, 150, 25);
		this.add(btnOk, 140, 400, 150, 35);
		this.add(btnCancel, 300, 400, 150, 35);

		/*
		 * btnOk.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { String message =
		 * String.format("Hello %s %s!", cbTitle.getSelectedItem(),tfName.getText());
		 * JOptionPane.showMessageDialog(ContactDialog.this, message,
		 * "Greet",JOptionPane.INFORMATION_MESSAGE); } });
		 * 
		 * btnCancel.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * ContactDialog.this.dispose(); } });
		 */

		ActionListener handleButtonClicks = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "OK":
					String message = String.format("Hello %s %s!", cbTitle.getSelectedItem(), tfName.getText());
					JOptionPane.showMessageDialog(ContactDialog.this, message, "Greet",
							JOptionPane.INFORMATION_MESSAGE);
					break;
				case "Cancel":
					ContactDialog.this.dispose();
					break;
				}
			}
		};

		btnOk.addActionListener(handleButtonClicks);
		btnCancel.addActionListener(handleButtonClicks);
	}

	void add(JComponent c, int x, int y, int width, int height) {
		c.setBounds(x, y, width, height);
		this.add(c);
	}
}
