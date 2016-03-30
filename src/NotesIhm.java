import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Interface representant plusieurs notes pour un même cours
 * Un clic sur un cours permet d'ouvrir celle-ci dans la classe
 * NoteIhm
 * 
 */
public class NotesIhm extends JPanel {

	public String cours;

	public NotesIhm(String cours) {
		this.cours = cours;
		this.setLayout(new GridBagLayout());

		JLabel label = new JLabel("Notes du cours de : " + cours);
		JButton button = new JButton("<");

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main.Instance.switchFrame(new FolderIhm());
			}
		});

		this.add(button);
		this.add(label);
	}
}
