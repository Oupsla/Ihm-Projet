package fr.univ.lille1.ihm.panel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.univ.lille1.ihm.listener.AddFolderRaccourci;
import fr.univ.lille1.ihm.main.Main;

/**
 * Interface representant plusieurs notes pour un même cours Un clic sur un
 * cours permet d'ouvrir celle-ci dans la classe NoteIhm
 * 
 */
public class NotesIhm extends JPanel {

	public String cours;
	private final String FILE_IMG_PATH = "./img/file.png";
	private JPanel filePanel;
	
	public void initHeaderPanel() {
		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout());
		JLabel label = new JLabel("Ensemble de vos Note du Cours : " + cours);
		headerPanel.add(label);
		headerPanel.setBackground(Color.WHITE);
		this.add(headerPanel,BorderLayout.PAGE_START);

	}
	public NotesIhm(final String cours) {
		this.cours = cours;
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);

		JButton button = new JButton("<");
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Main.Instance.switchFrame(new FolderIhm());
			}
		});
		this.add(button);
		this.setFocusable(true);
		initHeaderPanel();
		initContentPanel();
		this.setBackground(Color.WHITE);
		
		
	}
	
	public void initContentPanel() {
		filePanel = new JPanel();
		FlowLayout lay = new FlowLayout();
		lay.setVgap(20);
		lay.setHgap(30);
		filePanel.setLayout(lay);
		BufferedImage buttonIcon = null;
		try {
			buttonIcon = ImageIO.read(new File(FILE_IMG_PATH));
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ActionListener al = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Main.Instance.switchFrame(new NoteIhm(cours));
			}
		};

		JButton exempleCours1 = new JButton(new ImageIcon(buttonIcon));
		exempleCours1.setText("cour 1");
		exempleCours1.setBackground(Color.white);
		exempleCours1.addActionListener(al);
		JButton exempleCours2 = new JButton(new ImageIcon(buttonIcon));
		exempleCours2.setText("cour 2");
		exempleCours2.setBackground(Color.white);
		exempleCours2.addActionListener(al);
		JButton exempleCours3 = new JButton(new ImageIcon(buttonIcon));
		exempleCours3.setText("cour 3");
		exempleCours3.setBackground(Color.white);
		exempleCours3.addActionListener(al);
		
			
		filePanel.add(exempleCours1);
		filePanel.add(exempleCours2);
		filePanel.add(exempleCours3);
		filePanel.setBackground(Color.white);
		this.add(filePanel,BorderLayout.LINE_START);
	}
	

}
