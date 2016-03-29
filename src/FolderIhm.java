import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FolderIhm extends JPanel{
	
	public FolderIhm() {

		this.setLayout(new GridBagLayout()); 
		
		JLabel label = new JLabel("Enter username:");
		JTextField userName = new JTextField(20);

		this.add(label);
		this.add(userName); 
	}

}
