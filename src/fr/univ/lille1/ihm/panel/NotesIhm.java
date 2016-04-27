package fr.univ.lille1.ihm.panel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.univ.lille1.ihm.listener.SlideGaucheListener;
import fr.univ.lille1.ihm.main.Main;
import fr.univ.lille1.ihm.menu.MenuListener;

/**
 * Interface representant plusieurs notes pour un même cours Un clic sur un
 * cours permet d'ouvrir celle-ci dans la classe NoteIhm
 * 
 */
public class NotesIhm extends JPanel {

	public String cours;
	private final String FILE_IMG_PATH = "./img/file.png";
	private JPanel filePanel;
	private final String PLUS_IMG_PATH = "./img/plus.png";
	private JButton addButton;
	
	public void back() {
		FolderIhm notes = new FolderIhm(Main.mainFrame);
		Main.Instance.switchFrame(notes);
	}
	
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
		button.setToolTipText("Revenir aux cours");
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Main.Instance.switchFrame(new FolderIhm(Main.mainFrame));
			}
		});
		
		
		button.setFocusable(false);
		JPanel pGauche = new JPanel();
		pGauche.setLayout(new BoxLayout(pGauche, BoxLayout.Y_AXIS));
		pGauche.add(Box.createRigidArea(new Dimension(0, Main.hauteur / 2)));
		pGauche.add(button);
		
		this.add(pGauche,BorderLayout.WEST);

		
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
		exempleCours1.setBorder(BorderFactory.createEmptyBorder());
		exempleCours1.setText("cours 1");
		exempleCours1.setBackground(Color.white);
		exempleCours1.addActionListener(al);
		JButton exempleCours2 = new JButton(new ImageIcon(buttonIcon));
		exempleCours2.setBorder(BorderFactory.createEmptyBorder());
		exempleCours2.setText("cours 2");
		exempleCours2.setBackground(Color.white);
		exempleCours2.addActionListener(al);
		JButton exempleCours3 = new JButton(new ImageIcon(buttonIcon));
		exempleCours3.setBorder(BorderFactory.createEmptyBorder());
		exempleCours3.setText("cours 3");
		exempleCours3.setBackground(Color.white);
		exempleCours3.addActionListener(al);
		SlideGaucheListener slideListener = new SlideGaucheListener(this, "back", 300);
		filePanel.addMouseListener(slideListener);
		filePanel.addMouseMotionListener(slideListener);
		
			
		filePanel.add(exempleCours1);
		filePanel.add(exempleCours2);
		filePanel.add(exempleCours3);
		filePanel.setBackground(Color.white);
		this.add(filePanel,BorderLayout.CENTER);
	}
	

}
