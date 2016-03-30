import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Interface representant plusieurs cours sous forme de dossier
 * Un clic sur un des dossies crée une nouvelle instance de NotesIhm
 * et demande au Main de changer le panel actuel
 * 
 */
public class FolderIhm extends JPanel {

	public FolderIhm() {
		this.setLayout(new GridBagLayout());
		JLabel label = new JLabel("Ensemble de vos cours");
		JButton button = new JButton("CAR");
		JButton button2 = new JButton("IHM");

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				NotesIhm notes = new NotesIhm("CAR");
				Main.Instance.switchFrame(notes);

			}
		});

		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				NotesIhm notes = new NotesIhm("IHM");
				Main.Instance.switchFrame(notes);

			}
		});
		
		this.add(label);
		this.add(button);
		this.add(button2);
		

	}

}
