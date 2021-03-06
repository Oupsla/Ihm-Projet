package fr.univ.lille1.ihm.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import fr.univ.lille1.ihm.listener.SlideGaucheEditorListener;
import fr.univ.lille1.ihm.main.Main;
import fr.univ.lille1.ihm.menu.MenuListener;

/**
 * 
 * Classe representant une note de cours
 * 
 * Doit apparaitre : - Plusieurs sections sur la note (titre, introduction, 1ere
 * partie, ...) - Une fleche sur le cote droit pour acceder à la superNote - Un
 * bouton minimiser sur chaque sections pour miniser la partie (celle-ci
 * apparait donc sous une autre forme avec par exemple le debut de la section
 * suivi de 3 petits points) - Un bouton permettant de partager une section - Un
 * bouton permettant de partager toute sa note
 * 
 */
public class NoteIhm extends JPanel {

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

	public void back() {
		NotesIhm notes = new NotesIhm(cours);
		Main.Instance.switchFrame(notes);
	}

	public NoteIhm(final String cours) {
		this.setLayout(new BorderLayout());
		this.cours = cours;
		final JEditorPane ep = new JEditorPane();

		SlideGaucheEditorListener slideListener = new SlideGaucheEditorListener(ep, this, "back", 300);
		ep.addMouseListener(slideListener);
		ep.addMouseMotionListener(slideListener);

		MenuListener menu = new MenuListener() {

			@Override
			public void share() {
				// TODO Auto-generated method stub
				ToastMessage toastMessage = new ToastMessage(
						"Cette note a bien été partagée", 3000);
				toastMessage.setVisible(true);				
			}
	
			@Override
			public void edit() {
				// TODO Auto-generated method stub
				System.out.println("edit");
			}

			@Override
			public void delete() {
				// TODO Auto-generated method stub
				System.out.println("delete");
			}

			@Override
			public void back() {
				// TODO Auto-generated method stub
				System.out.println("back");
			}
		};

		//ep.addMouseListener(menu);
		//ep.addMouseMotionListener(menu);


		ep.setContentType("text/html");
		ep.setText(titreChapite + titrePartie1 + textePartie1 + titrePartie2
				+ textePartie2);
		this.add(ep, BorderLayout.CENTER);

		JButton partagerLaNote = new JButton("Partager ce cours");
		JPanel pPartage = new JPanel(new GridBagLayout());
		pPartage.add(partagerLaNote);
		partagerLaNote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ToastMessage toastMessage = new ToastMessage(
						"Le cours a bien été partagé", 3000);
				toastMessage.setVisible(true);
			}
		});
		this.add(pPartage, BorderLayout.SOUTH);

		final JButton expandChap = new JButton("-");
		expandChap.setMargin(new java.awt.Insets(0, 2, 0, 3));
		expandChap.setFocusable(false);
		expandChap.setToolTipText("Minimiser cette partie");

		final JButton expandPart1 = new JButton("-");
		expandPart1.setMargin(new java.awt.Insets(0, 2, 0, 3));
		expandPart1.setFocusable(false);
		expandPart1.setToolTipText("Minimiser cette partie");

		final JButton expandPart2 = new JButton("-");
		expandPart2.setMargin(new java.awt.Insets(0, 2, 0, 3));
		expandPart2.setFocusable(false);
		expandPart2.setToolTipText("Minimiser cette partie");

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
				NotesIhm notes = new NotesIhm(cours);
				Main.Instance.switchFrame(notes);

			}
		});
		back.setFocusable(false);
		back.setToolTipText("Revenir aux notes");
		JPanel pBack = new JPanel();
		pBack.setLayout(new BoxLayout(pBack, BoxLayout.Y_AXIS));
		pBack.add(Box.createRigidArea(new Dimension(0, Main.hauteur / 2)));
		pBack.add(back);
		wraperLeft.add(pBack, BorderLayout.WEST);

		this.add(wraperLeft, BorderLayout.WEST);


		JPanel wraperRight = new JPanel(new BorderLayout());
		JButton superNote = new JButton(">");
		superNote.setToolTipText("Aller à la supernote");
		superNote.setFocusable(false);
		JPanel pDroit = new JPanel();
		pDroit.setLayout(new BoxLayout(pDroit, BoxLayout.Y_AXIS));
		pDroit.add(Box.createRigidArea(new Dimension(0, Main.hauteur / 2)));
		pDroit.add(superNote);
		wraperRight.add(pDroit, BorderLayout.EAST);

		superNote.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SuperNoteIhm superNote = new SuperNoteIhm(cours);
				Main.Instance.switchFrame(superNote);

			}
		});


		JButton btnShare1 = new JButton("s");
		JButton btnShare2 = new JButton("s");
		JButton btnShare3 = new JButton("s");
		btnShare1.setMargin(new java.awt.Insets(0, 2, 0, 3));
		btnShare2.setMargin(new java.awt.Insets(0, 2, 0, 3));
		btnShare3.setMargin(new java.awt.Insets(0, 2, 0, 3));
		btnShare1.setFocusable(false);
		btnShare2.setFocusable(false);
		btnShare3.setFocusable(false);

		btnShare1.setToolTipText("Partager cette partie");
		btnShare2.setToolTipText("Partager cette partie");
		btnShare3.setToolTipText("Partager cette partie");


		ActionListener actionPartageSection = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ToastMessage toastMessage = new ToastMessage(
						"Cette partie a bien été partagée", 3000);
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

		wraperRight.add(pShare, BorderLayout.WEST);

		this.add(wraperRight, BorderLayout.EAST);

		expandChap.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				chapOuvert = !chapOuvert;
				if (expandChap.getText().equals("+")) {
					expandChap.setText("-");
					expandChap.setToolTipText("Minimiser cette partie");
					expandChap.setMargin(new java.awt.Insets(0, 2, 0, 3));
					ep.setText(titreChapite + titrePartie1 + textePartie1
							+ titrePartie2 + textePartie2);
					expandPart1.setVisible(true);
					expandPart2.setVisible(true);

					btnShare2.setVisible(true);
					btnShare3.setVisible(true);

					expandPart1.setText("-");
					expandPart1.setToolTipText("Minimiser cette partie");
					expandPart1.setMargin(new java.awt.Insets(0, 2, 0, 3));
					expandPart2.setText("-");
					expandPart2.setMargin(new java.awt.Insets(0, 2, 0, 3));
				} else {
					expandChap.setText("+");
					expandChap.setToolTipText("Etendre cette partie");
					expandChap.setMargin(new java.awt.Insets(0, 0, 0, 0));
					ep.setText(titreChapite + ligneHorizontale);
					expandPart1.setVisible(false);
					expandPart2.setVisible(false);

					btnShare2.setVisible(false);
					btnShare3.setVisible(false);

				}

			}
		});

		expandPart2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				partie2Ouverte = !partie2Ouverte;
				if (expandPart2.getText().equals("+")) {
					expandPart2.setText("-");
					expandPart2.setToolTipText("Minimiser cette partie");
					expandPart2.setMargin(new java.awt.Insets(0, 2, 0, 3));
					String finale = titreChapite;
					if (expandPart1.getText().equals("-")) {
						finale += titrePartie1 + textePartie1 + titrePartie2
								+ textePartie2;
					} else {
						finale += titrePartie1 + ligneHorizontale
								+ titrePartie2 + textePartie2;
					}
					ep.setText(finale);
				} else {
					expandPart2.setText("+");
					expandPart2.setToolTipText("Etendre cette partie");
					expandPart2.setMargin(new java.awt.Insets(0, 0, 0, 0));
					String finale = titreChapite;
					if (expandPart1.getText().equals("-")) {
						finale += titrePartie1 + textePartie1 + titrePartie2
								+ ligneHorizontale;
					} else {
						finale += titrePartie1 + ligneHorizontale
								+ titrePartie2 + ligneHorizontale;
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
					//NoteIhm.this.add(p, BorderLayout.WEST);


					JPanel pShare = new JPanel();
					pShare.setLayout(new BoxLayout(pShare, BoxLayout.Y_AXIS));
					pShare.add(Box.createRigidArea(new Dimension(0, 16)));
					pShare.add(btnShare1);
					pShare.add(Box.createRigidArea(new Dimension(0, 25)));
					pShare.add(btnShare2);
					pShare.add(Box.createRigidArea(new Dimension(0, 86)));
					pShare.add(btnShare3);

					wraperRight.add(pShare, BorderLayout.WEST);



					expandPart1.setText("-");
					expandPart1.setToolTipText("Minimiser cette partie");
					expandPart1.setMargin(new java.awt.Insets(0, 2, 0, 3));
					String finale = titreChapite;
					if (expandPart2.getText().equals("-")) {
						finale += titrePartie1 + textePartie1 + titrePartie2
								+ textePartie2;
					} else {
						finale += titrePartie1 + textePartie1 + titrePartie2
								+ ligneHorizontale;
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
					//NoteIhm.this.add(p, BorderLayout.WEST);


					JPanel pShare = new JPanel();
					pShare.setLayout(new BoxLayout(pShare, BoxLayout.Y_AXIS));
					pShare.add(Box.createRigidArea(new Dimension(0, 16)));
					pShare.add(btnShare1);
					pShare.add(Box.createRigidArea(new Dimension(0, 25)));
					pShare.add(btnShare2);
					pShare.add(Box.createRigidArea(new Dimension(0, 31)));
					pShare.add(btnShare3);

					wraperRight.add(pShare, BorderLayout.WEST);

					expandPart1.setText("+");
					expandPart1.setToolTipText("Etendre cette partie");
					expandPart1.setMargin(new java.awt.Insets(0, 0, 0, 0));
					String finale = titreChapite;
					if (expandPart2.getText().equals("-")) {
						System.out.println("coucou");
						finale += titrePartie1 + ligneHorizontale
								+ titrePartie2 + textePartie2;
					} else {
						finale += titrePartie1 + ligneHorizontale
								+ titrePartie2 + ligneHorizontale;
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
