package fr.univ.lille1.ihm.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import fr.univ.lille1.ihm.listener.SlideGaucheEditorListener;
import fr.univ.lille1.ihm.main.Main;

/**
 * 
 * Class representant la super note
 * 
 * Doit figurer :
 * 
 * - Fleche sur la gauche pour revenir à sa note - Toutes les sections comme
 * dans la note - Pour chaque section un petit menu qui apparait quand on
 * survole la note avec les options ("Rajouter dans sa note" , La valeur de la
 * section (+10, +3, ...) , "Revisions" (bouton permettant d'acceder à toutes
 * les versions pour cette section))
 * 
 */
public class SuperNoteIhm extends JPanel {

	private static Boolean partie1Ouverte = true;
	private static Boolean partie2Ouverte = true;
	private static Boolean chapOuvert = true;

	private static String titreChapite = "<h1>Chapître 1</h1>";
	private static String titrePartie1 = "<h2>Partie I</h2>";
	private static String textePartie1 = "<p>Saraceni tamen nec amici nobis umquam nec hostes optandi, ultro citroque discursantes quicquid inveniri poterat momento temporis parvi vastabant milvorum rapacium similes, qui si praedam dispexerint celsius, volatu rapiunt celeri, aut nisi impetraverint, non inmorantur.</p>";
	private static String titrePartie2 = "<h2>Partie II</h2>";
	private static String textePartie2 = "<p>Haec et huius modi quaedam innumerabilia ultrix facinorum impiorum bonorumque praemiatrix aliquotiens operatur Adrastia atque utinam semper quam vocabulo duplici etiam Nemesim appellamus: ius quoddam sublime numinis efficacis, humanarum mentium opinione lunari circulo superpositum, vel ut definiunt alii, substantialis tutela generali potentia partilibus praesidens fatis, quam theologi veteres fingentes Iustitiae filiam ex abdita quadam aeternitate tradunt omnia despectare terrena.</p>"
			+ "							<p>Quibus ita sceleste patratis Paulus cruore perfusus reversusque ad principis castra multos coopertos paene catenis adduxit in squalorem deiectos atque maestitiam, quorum adventu intendebantur eculei uncosque parabat carnifex et tormenta. et ex is proscripti sunt plures actique in exilium alii, non nullos gladii consumpsere poenales. nec enim quisquam facile meminit sub Constantio, ubi susurro tenus haec movebantur, quemquam absolutum.</p>"
			+ "							<p>Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis.</p>";
	private static String ligneHorizontale = "<hr>";

	private String cours;

	public void addFolder() {
		NotesIhm notes = new NotesIhm(cours);
		Main.Instance.switchFrame(notes);
	}

	public SuperNoteIhm(final String cours) {
		this.setLayout(new BorderLayout());
		this.cours = cours;
		final JEditorPane ep = new JEditorPane();
		ep.setEditable(false);

		SlideGaucheEditorListener slideListener = new SlideGaucheEditorListener(ep, this, "addFolder", 300);
		ep.addMouseListener(slideListener);
		ep.addMouseMotionListener(slideListener);

		ep.setContentType("text/html");
		ep.setText(titreChapite + titrePartie1 + textePartie1 + titrePartie2 + textePartie2);
		this.add(ep, BorderLayout.CENTER);

		final JButton expandChap = new JButton("-");
		expandChap.setMargin(new java.awt.Insets(0, 2, 0, 3));
		expandChap.setFocusable(false);

		final JButton expandPart1 = new JButton("-");
		expandPart1.setMargin(new java.awt.Insets(0, 2, 0, 3));
		expandPart1.setFocusable(false);

		final JButton expandPart2 = new JButton("-");
		expandPart2.setMargin(new java.awt.Insets(0, 2, 0, 3));
		expandPart2.setFocusable(false);

		JPanel wraperLeft = new JPanel(new BorderLayout());

		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.add(Box.createRigidArea(new Dimension(0, 16)));
		p.add(expandChap);
		p.add(Box.createRigidArea(new Dimension(0, 25)));
		p.add(expandPart1);
		p.add(Box.createRigidArea(new Dimension(0, 86)));
		p.add(expandPart2);

		wraperLeft.add(p, BorderLayout.EAST);

		JButton back = new JButton("<");
		back.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				NoteIhm note = new NoteIhm(cours);
				Main.Instance.switchFrame(note);

			}
		});
		back.setFocusable(false);
		JPanel pBack = new JPanel();
		pBack.setLayout(new BoxLayout(pBack, BoxLayout.Y_AXIS));
		pBack.add(Box.createRigidArea(new Dimension(0, Main.hauteur / 2)));
		pBack.add(back);
		wraperLeft.add(pBack, BorderLayout.WEST);

		this.add(wraperLeft, BorderLayout.WEST);

		JPanel wraperRight = new JPanel(new BorderLayout());

		JButton btnShare1 = new JButton("+");
		JButton btnShare2 = new JButton("+");
		JButton btnShare3 = new JButton("+");
		btnShare1.setMargin(new java.awt.Insets(0, 2, 0, 3));
		btnShare2.setMargin(new java.awt.Insets(0, 2, 0, 3));
		btnShare3.setMargin(new java.awt.Insets(0, 2, 0, 3));
		btnShare1.setFocusable(false);
		btnShare2.setFocusable(false);
		btnShare3.setFocusable(false);

		btnShare1.setToolTipText("Ajouter cette section");
		btnShare2.setToolTipText("Ajouter cette section");
		btnShare3.setToolTipText("Ajouter cette section");

		ActionListener actionPartageSection = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ToastMessage toastMessage = new ToastMessage("Cette partie a bien été partagée", 3000);
				toastMessage.setVisible(true);
			}
		};

		btnShare1.addActionListener(actionPartageSection);
		btnShare2.addActionListener(actionPartageSection);
		btnShare3.addActionListener(actionPartageSection);

		JPanel pShare = new JPanel();
		pShare.setLayout(new BoxLayout(pShare, BoxLayout.Y_AXIS));
		pShare.add(Box.createRigidArea(new Dimension(0, 16)));
		pShare.add(btnShare1);
		pShare.add(Box.createRigidArea(new Dimension(0, 25)));
		pShare.add(btnShare2);
		pShare.add(Box.createRigidArea(new Dimension(0, 86)));
		pShare.add(btnShare3);

		JButton btnValeur1 = new JButton("R");
		JButton btnValeur2 = new JButton("R");
		JButton btnValeur3 = new JButton("R");
		btnValeur1.setMargin(new java.awt.Insets(0, 2, 0, 3));
		btnValeur2.setMargin(new java.awt.Insets(0, 2, 0, 3));
		btnValeur3.setMargin(new java.awt.Insets(0, 2, 0, 3));
		btnValeur1.setFocusable(false);
		btnValeur2.setFocusable(false);
		btnValeur3.setFocusable(false);

		ActionListener actionRevision = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] choices = { "1.0", "1.1", "1.9", "2.0", "2.5", "2.5.1" };
				String input = (String) JOptionPane.showInputDialog(null, "Version...", "Choisir la version",
						JOptionPane.QUESTION_MESSAGE, null, // Use
															// default
															// icon
						choices, // Array of choices
						choices[1]); // Initial choice
			}
		};

		btnValeur1.addActionListener(actionRevision);
		btnValeur3.addActionListener(actionRevision);
		btnValeur2.addActionListener(actionRevision);

		JPanel pValeur = new JPanel();
		pValeur.setLayout(new BoxLayout(pValeur, BoxLayout.Y_AXIS));
		pValeur.add(Box.createRigidArea(new Dimension(0, 16)));
		pValeur.add(btnValeur1);
		pValeur.add(Box.createRigidArea(new Dimension(0, 25)));
		pValeur.add(btnValeur2);
		pValeur.add(Box.createRigidArea(new Dimension(0, 86)));
		pValeur.add(btnValeur3);

		wraperRight.add(pShare, BorderLayout.WEST);
		wraperRight.add(pValeur, BorderLayout.EAST);

		this.add(wraperRight, BorderLayout.EAST);

		expandChap.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				chapOuvert = !chapOuvert;
				if (expandChap.getText().equals("+")) {
					expandChap.setText("-");
					expandChap.setMargin(new java.awt.Insets(0, 2, 0, 3));
					ep.setText(titreChapite + titrePartie1 + textePartie1 + titrePartie2 + textePartie2);
					expandPart1.setVisible(true);
					expandPart2.setVisible(true);

					btnShare2.setVisible(true);
					btnShare3.setVisible(true);
					btnValeur2.setVisible(true);
					btnValeur3.setVisible(true);

					expandPart1.setText("-");
					expandPart1.setMargin(new java.awt.Insets(0, 2, 0, 3));
					expandPart2.setText("-");
					expandPart2.setMargin(new java.awt.Insets(0, 2, 0, 3));
				} else {
					expandChap.setText("+");
					expandChap.setMargin(new java.awt.Insets(0, 0, 0, 0));
					ep.setText(titreChapite + ligneHorizontale);
					expandPart1.setVisible(false);
					expandPart2.setVisible(false);

					btnShare2.setVisible(false);
					btnShare3.setVisible(false);
					btnValeur2.setVisible(false);
					btnValeur3.setVisible(false);

				}

			}
		});

		expandPart2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				partie2Ouverte = !partie2Ouverte;
				if (expandPart2.getText().equals("+")) {
					expandPart2.setText("-");
					expandPart2.setMargin(new java.awt.Insets(0, 2, 0, 3));
					String finale = titreChapite;
					if (expandPart1.getText().equals("-")) {
						finale += titrePartie1 + textePartie1 + titrePartie2 + textePartie2;
					} else {
						finale += titrePartie1 + ligneHorizontale + titrePartie2 + textePartie2;
					}
					ep.setText(finale);
				} else {
					expandPart2.setText("+");
					expandPart2.setMargin(new java.awt.Insets(0, 0, 0, 0));
					String finale = titreChapite;
					if (expandPart1.getText().equals("-")) {
						finale += titrePartie1 + textePartie1 + titrePartie2 + ligneHorizontale;
					} else {
						finale += titrePartie1 + ligneHorizontale + titrePartie2 + ligneHorizontale;
					}
					ep.setText(finale);

				}

			}
		});

		expandPart1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				partie1Ouverte = !partie1Ouverte;
				if (expandPart1.getText().equals("+")) {
					JPanel p = new JPanel();
					p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
					p.add(Box.createRigidArea(new Dimension(0, 16)));
					p.add(expandChap);
					p.add(Box.createRigidArea(new Dimension(0, 25)));
					p.add(expandPart1);
					p.add(Box.createRigidArea(new Dimension(0, 86)));
					p.add(expandPart2);

					wraperLeft.add(p, BorderLayout.EAST);
					// NoteIhm.this.add(p, BorderLayout.WEST);

					JPanel pShare = new JPanel();
					pShare.setLayout(new BoxLayout(pShare, BoxLayout.Y_AXIS));
					pShare.add(Box.createRigidArea(new Dimension(0, 16)));
					pShare.add(btnShare1);
					pShare.add(Box.createRigidArea(new Dimension(0, 25)));
					pShare.add(btnShare2);
					pShare.add(Box.createRigidArea(new Dimension(0, 86)));
					pShare.add(btnShare3);

					wraperRight.add(pShare, BorderLayout.WEST);

					JPanel pValeur = new JPanel();
					pValeur.setLayout(new BoxLayout(pValeur, BoxLayout.Y_AXIS));
					pValeur.add(Box.createRigidArea(new Dimension(0, 16)));
					pValeur.add(btnValeur1);
					pValeur.add(Box.createRigidArea(new Dimension(0, 25)));
					pValeur.add(btnValeur2);
					pValeur.add(Box.createRigidArea(new Dimension(0, 86)));
					pValeur.add(btnValeur3);

					wraperRight.add(pValeur, BorderLayout.EAST);

					expandPart1.setText("-");
					expandPart1.setMargin(new java.awt.Insets(0, 2, 0, 3));
					String finale = titreChapite;
					if (expandPart2.getText().equals("-")) {
						finale += titrePartie1 + textePartie1 + titrePartie2 + textePartie2;
					} else {
						finale += titrePartie1 + textePartie1 + titrePartie2 + ligneHorizontale;
					}
					ep.setText(finale);

				} else { //

					JPanel p = new JPanel();
					p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
					p.add(Box.createRigidArea(new Dimension(0, 16)));
					p.add(expandChap);
					p.add(Box.createRigidArea(new Dimension(0, 25)));
					p.add(expandPart1);
					p.add(Box.createRigidArea(new Dimension(0, 31)));
					p.add(expandPart2);

					wraperLeft.add(p, BorderLayout.EAST);
					// NoteIhm.this.add(p, BorderLayout.WEST);

					JPanel pShare = new JPanel();
					pShare.setLayout(new BoxLayout(pShare, BoxLayout.Y_AXIS));
					pShare.add(Box.createRigidArea(new Dimension(0, 16)));
					pShare.add(btnShare1);
					pShare.add(Box.createRigidArea(new Dimension(0, 25)));
					pShare.add(btnShare2);
					pShare.add(Box.createRigidArea(new Dimension(0, 31)));
					pShare.add(btnShare3);

					wraperRight.add(pShare, BorderLayout.WEST);

					JPanel pValeur = new JPanel();
					pValeur.setLayout(new BoxLayout(pValeur, BoxLayout.Y_AXIS));
					pValeur.add(Box.createRigidArea(new Dimension(0, 16)));
					pValeur.add(btnValeur1);
					pValeur.add(Box.createRigidArea(new Dimension(0, 25)));
					pValeur.add(btnValeur2);
					pValeur.add(Box.createRigidArea(new Dimension(0, 31)));
					pValeur.add(btnValeur3);

					wraperRight.add(pValeur, BorderLayout.EAST);

					expandPart1.setText("+");
					expandPart1.setMargin(new java.awt.Insets(0, 0, 0, 0));
					String finale = titreChapite;
					if (expandPart2.getText().equals("-")) {
						System.out.println("coucou");
						finale += titrePartie1 + ligneHorizontale + titrePartie2 + textePartie2;
					} else {
						finale += titrePartie1 + ligneHorizontale + titrePartie2 + ligneHorizontale;
					}

					ep.setText(finale);
				}

			}
		});

		if (!partie1Ouverte) {
			expandPart1.doClick();
		}

		if (!partie2Ouverte) {
			expandPart2.doClick();
		}

		if (!chapOuvert) {
			expandChap.doClick();
		}

	}

	private class ToastMessage extends JDialog {
		int miliseconds;

		public ToastMessage(String toastString, int time) {
			this.miliseconds = time;
			setUndecorated(true);
			getContentPane().setLayout(new BorderLayout(0, 0));

			JPanel panel = new JPanel();
			panel.setBackground(Color.GRAY);
			panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
			getContentPane().add(panel, BorderLayout.CENTER);

			JLabel toastLabel = new JLabel("");
			toastLabel.setText(toastString);
			toastLabel.setFont(new Font("Dialog", Font.BOLD, 12));
			toastLabel.setForeground(Color.WHITE);

			setBounds(100, 100, toastLabel.getPreferredSize().width + 20, 31);

			setAlwaysOnTop(true);
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			int y = dim.height / 2 - getSize().height / 2;
			int half = y / 2;
			setLocation(dim.width / 2 - getSize().width / 2, y + half);
			panel.add(toastLabel);
			setVisible(false);

			new Thread() {
				public void run() {
					try {
						Thread.sleep(miliseconds);
						dispose();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}.start();
		}
	}
}
