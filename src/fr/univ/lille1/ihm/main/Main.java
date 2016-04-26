package fr.univ.lille1.ihm.main;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.univ.lille1.ihm.panel.FolderIhm;
import fr.univ.lille1.ihm.panel.Revision;

public class Main {

	public static Main Instance;

	public final static int largeur = 800;
	public final static int hauteur = 600;

	public static JFrame mainFrame;
	private JPanel panelActuel;

	public Main() {
		mainFrame = new JFrame("Projet Ihm");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setPreferredSize(new Dimension(largeur, hauteur));
		mainFrame.getContentPane().setLayout(new CardLayout());
		mainFrame.setResizable(false);
		panelActuel = new FolderIhm(mainFrame);
		//panelActuel = new Revision("cucou");
		mainFrame.add(panelActuel);
		mainFrame.pack();
		mainFrame.setBackground(Color.white);
		mainFrame.getContentPane().setBackground(Color.white);
		mainFrame.setVisible(true);
	}

	public void switchFrame(final JPanel nextPanel) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame.getContentPane().hide();
					mainFrame.getContentPane().removeAll();
					panelActuel = nextPanel;
					mainFrame.getContentPane().add(nextPanel);
					mainFrame.getContentPane().show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main m = new Main();
					Main.Instance = m;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
