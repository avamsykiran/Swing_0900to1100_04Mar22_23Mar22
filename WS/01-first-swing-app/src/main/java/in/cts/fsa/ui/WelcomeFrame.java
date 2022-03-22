package in.cts.fsa.ui;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class WelcomeFrame extends JDialog /*JFrame*/ {

	public WelcomeFrame() {
		this.setTitle("Welcome Screen");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(25, 25, 500, 500);
	}
}
