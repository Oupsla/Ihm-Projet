import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Interface representant plusieurs notes pour un même cours Un clic sur un
 * cours permet d'ouvrir celle-ci dans la classe NoteIhm
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

		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main.Instance.switchFrame(new NoteIhm(cours));
			}
		};

		JButton exempleCours1 = new JButton("Cours 1");
		exempleCours1.addActionListener(al);
		JButton exempleCours2 = new JButton("Cours 2");
		exempleCours2.addActionListener(al);
		JButton exempleCours3 = new JButton("Cours 3");
		exempleCours3.addActionListener(al);

		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 0;
		this.add(button, gc);
		gc.gridx = 1;
		this.add(label, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		this.add(exempleCours1, gc);
		gc.gridy++;
		this.add(exempleCours2, gc);
		gc.gridy++;
		this.add(exempleCours3, gc);
		gc.gridy++;

	}

}
