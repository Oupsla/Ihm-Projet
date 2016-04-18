package fr.univ.lille1.ihm.panel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fr.univ.lille1.ihm.listener.AddFolderRaccourci;
import fr.univ.lille1.ihm.main.Main;

/**
 * Interface representant plusieurs cours sous forme de dossier
 * Un clic sur un des dossies crée une nouvelle instance de NotesIhm
 * et demande au Main de changer le panel actuel
 * 
 */
public class FolderIhm extends JPanel {

	private final String FOLDER_IMG_PATH = "./img/folder.png";
	private JPanel folderPanel;
	public void initHeaderPanel() {
		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout());
		JLabel label = new JLabel("Ensemble de vos cours :");
		headerPanel.add(label);
		headerPanel.setBackground(Color.white);
		this.add(headerPanel,BorderLayout.PAGE_START);
	}
	public FolderIhm() {
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		this.setFocusable(true);
		this.addKeyListener(new AddFolderRaccourci(this));
		initHeaderPanel();
		initContentPanel();
		this.setBackground(Color.WHITE);
		
	}
	public void initContentPanel() {
		folderPanel = new JPanel();
		FlowLayout lay = new FlowLayout();
		lay.setVgap(20);
		lay.setHgap(30);
		folderPanel.setLayout(lay);
		BufferedImage buttonIcon = null;
		try {
			buttonIcon = ImageIO.read(new File(FOLDER_IMG_PATH));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		JButton button = new JButton(new ImageIcon(buttonIcon));
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setText("CAR");
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
	    button.setHorizontalTextPosition(SwingConstants.CENTER);
	    button.setBackground(Color.white);
		JButton button2 = new JButton(new ImageIcon(buttonIcon));
		button2.setText("IHM");
		button2.setVerticalTextPosition(SwingConstants.BOTTOM);
	    button2.setHorizontalTextPosition(SwingConstants.CENTER);
		button2.setBackground(Color.white);
	    button2.setBorder(BorderFactory.createEmptyBorder());
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				NotesIhm notes = new NotesIhm("CAR");
				Main.Instance.switchFrame(notes);

			}
		});

		button2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				NotesIhm notes = new NotesIhm("IHM");
				Main.Instance.switchFrame(notes);

			}
		});
		folderPanel.add(button);
		folderPanel.add(button2);
		folderPanel.setBackground(Color.white);
		this.add(folderPanel,BorderLayout.LINE_START);
	}
	public void addFolder() {
		BufferedImage buttonIcon = null;
		try {
			buttonIcon = ImageIO.read(new File(FOLDER_IMG_PATH));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JButton button2 = new JButton(new ImageIcon(buttonIcon));
		button2.setText("ACT");
		button2.setVerticalTextPosition(SwingConstants.BOTTOM);
	    button2.setHorizontalTextPosition(SwingConstants.CENTER);
		button2.setBackground(Color.white);
	    button2.setBorder(BorderFactory.createEmptyBorder());
		button2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				NotesIhm notes = new NotesIhm("CAR");
				Main.Instance.switchFrame(notes);

			}
		});
		folderPanel.add(button2);
		this.validate();
		this.repaint();
	}
}
