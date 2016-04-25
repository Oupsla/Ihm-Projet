package fr.univ.lille1.ihm.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
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
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import fr.univ.lille1.ihm.listener.SlideGaucheEditorListener;
import fr.univ.lille1.ihm.main.Main;

/**
 * 
 * Classe representant les différentes versions/revisions pour une partie d'un
 * cours
 * 
 * Doit apparaitre : - Plusieurs parties écrites pas différents élèves Une
 * fleche sur le cote gauche pour revenir à la superNote - Un bouton permettant
 * de définir comme "ma partie"- Un bouton permettant de voter pour cette
 * partie. Afficher le score de chaque partie des différents élèves
 * 
 */
public class Revision extends JPanel {

	private static Boolean partie1Ouverte = true;
	private static Boolean partie2Ouverte = true;
	private static Boolean chapOuvert = true;

	private static String titrePartie1 = "<h2>Partie I</h2>";
	private static String textePartie1 = "<p>Saraceni tamen nec amici nobis umquam nec hostes optandi, ultro citroque discursantes quicquid inveniri poterat momento temporis parvi vastabant milvorum rapacium similes, qui si praedam dispexerint celsius, volatu rapiunt celeri, aut nisi impetraverint, non inmorantur.</p>";
	private static String ligneHorizontale = "<hr>";

	private String cours;

	public void addFolder() {
		NotesIhm notes = new NotesIhm(cours);
		Main.Instance.switchFrame(notes);
	}

	public Revision(final String cours) {
		this.setLayout(new BorderLayout());
		this.cours = cours;
		final JEditorPane ep = new JEditorPane();
		ep.setEditable(false);

		SlideGaucheEditorListener slideListener = new SlideGaucheEditorListener(ep, this, "addFolder", 300);
		ep.addMouseListener(slideListener);
		ep.addMouseMotionListener(slideListener);

		ep.setContentType("text/html");
		ep.setText(titrePartie1 + textePartie1 + ligneHorizontale + titrePartie1 + textePartie1 + ligneHorizontale
				+ titrePartie1 + textePartie1 + ligneHorizontale + titrePartie1 + textePartie1 + ligneHorizontale
				+ titrePartie1 + textePartie1);
		this.add(new JScrollPane(ep), BorderLayout.CENTER);

		final JButton btnScore1 = new JButton("36");
		btnScore1.setMargin(new java.awt.Insets(0, 2, 0, 3));
		btnScore1.setFocusable(false);
		btnScore1.setBackground(Color.WHITE);
		btnScore1.setEnabled(false);
		final JButton btnMin1 = new JButton("-");
		btnMin1.setMargin(new java.awt.Insets(0, 2, 0, 3));
		btnMin1.setFocusable(false);
		final JButton btnPlus1 = new JButton("+");
		btnPlus1.setMargin(new java.awt.Insets(0, 0, 0, 0));
		btnPlus1.setFocusable(false);
		btnPlus1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int score = Integer.parseInt(btnScore1.getText().toString());
				score++;
				String txt = score + "";
				btnScore1.setText(txt);
			}
		});
		btnMin1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int score = Integer.parseInt(btnScore1.getText().toString());
				score--;
				String txt = score + "";
				btnScore1.setText(txt);
			}
		});

		JPanel panelScoreEtVote1 = new JPanel(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 2;
		panelScoreEtVote1.add(btnScore1, gc);
		gc.gridwidth = 1;
		gc.gridy++;
		panelScoreEtVote1.add(btnMin1, gc);
		gc.gridx++;
		panelScoreEtVote1.add(btnPlus1, gc);

		final JButton btnScore2 = new JButton("29");
		btnScore2.setMargin(new java.awt.Insets(0, 2, 0, 3));
		btnScore2.setFocusable(false);
		btnScore2.setBackground(Color.WHITE);
		btnScore2.setEnabled(false);
		final JButton btnMin2 = new JButton("-");
		btnMin2.setMargin(new java.awt.Insets(0, 2, 0, 3));
		btnMin2.setFocusable(false);
		final JButton btnPlus2 = new JButton("+");
		btnPlus2.setMargin(new java.awt.Insets(0, 0, 0, 0));
		btnPlus2.setFocusable(false);
		btnPlus2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int score = Integer.parseInt(btnScore2.getText().toString());
				score++;
				String txt = score + "";
				btnScore2.setText(txt);
			}
		});
		btnMin2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int score = Integer.parseInt(btnScore2.getText().toString());
				score--;
				String txt = score + "";
				btnScore2.setText(txt);
			}
		});

		JPanel panelScoreEtVote2 = new JPanel(new GridBagLayout());
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 2;
		panelScoreEtVote2.add(btnScore2, gc);
		gc.gridwidth = 1;
		gc.gridy++;
		panelScoreEtVote2.add(btnMin2, gc);
		gc.gridx++;
		panelScoreEtVote2.add(btnPlus2, gc);

		final JButton btnScore3 = new JButton("15");
		btnScore3.setMargin(new java.awt.Insets(0, 2, 0, 3));
		btnScore3.setFocusable(false);
		btnScore3.setBackground(Color.WHITE);
		btnScore3.setEnabled(false);
		final JButton btnMin3 = new JButton("-");
		btnMin3.setMargin(new java.awt.Insets(0, 2, 0, 3));
		btnMin3.setFocusable(false);
		final JButton btnPlus3 = new JButton("+");
		btnPlus3.setMargin(new java.awt.Insets(0, 0, 0, 0));
		btnPlus3.setFocusable(false);
		btnPlus3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int score = Integer.parseInt(btnScore3.getText().toString());
				score++;
				String txt = score + "";
				btnScore3.setText(txt);
			}
		});
		btnMin3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int score = Integer.parseInt(btnScore3.getText().toString());
				score--;
				String txt = score + "";
				btnScore3.setText(txt);
			}
		});

		JPanel panelScoreEtVote3 = new JPanel(new GridBagLayout());
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 2;
		panelScoreEtVote3.add(btnScore3, gc);
		gc.gridwidth = 1;
		gc.gridy++;
		panelScoreEtVote3.add(btnMin3, gc);
		gc.gridx++;
		panelScoreEtVote3.add(btnPlus3, gc);

		final JButton btnScore4 = new JButton("4");
		btnScore4.setMargin(new java.awt.Insets(0, 2, 0, 3));
		btnScore4.setFocusable(false);
		btnScore4.setBackground(Color.WHITE);
		btnScore4.setEnabled(false);
		final JButton btnMin4 = new JButton("-");
		btnMin4.setMargin(new java.awt.Insets(0, 2, 0, 3));
		btnMin4.setFocusable(false);
		final JButton btnPlus4 = new JButton("+");
		btnPlus4.setMargin(new java.awt.Insets(0, 0, 0, 0));
		btnPlus4.setFocusable(false);
		btnPlus4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int score = Integer.parseInt(btnScore4.getText().toString());
				score++;
				String txt = score + "";
				btnScore4.setText(txt);
			}
		});
		btnMin4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int score = Integer.parseInt(btnScore4.getText().toString());
				score--;
				String txt = score + "";
				btnScore4.setText(txt);
			}
		});

		JPanel panelScoreEtVote4 = new JPanel(new GridBagLayout());
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 2;
		panelScoreEtVote4.add(btnScore4, gc);
		gc.gridwidth = 1;
		gc.gridy++;
		panelScoreEtVote4.add(btnMin4, gc);
		gc.gridx++;
		panelScoreEtVote4.add(btnPlus4, gc);

		final JButton btnScore5 = new JButton("0");
		btnScore5.setMargin(new java.awt.Insets(0, 2, 0, 3));
		btnScore5.setFocusable(false);
		btnScore5.setBackground(Color.WHITE);
		btnScore5.setEnabled(false);
		final JButton btnMin5 = new JButton("-");
		btnMin5.setMargin(new java.awt.Insets(0, 2, 0, 3));
		btnMin5.setFocusable(false);
		final JButton btnPlus5 = new JButton("+");
		btnPlus5.setMargin(new java.awt.Insets(0, 0, 0, 0));
		btnPlus5.setFocusable(false);
		btnPlus5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int score = Integer.parseInt(btnScore5.getText().toString());
				score++;
				String txt = score + "";
				btnScore5.setText(txt);
			}
		});
		btnMin5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int score = Integer.parseInt(btnScore5.getText().toString());
				score--;
				String txt = score + "";
				btnScore5.setText(txt);
			}
		});

		JPanel panelScoreEtVote5 = new JPanel(new GridBagLayout());
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 2;
		panelScoreEtVote5.add(btnScore5, gc);
		gc.gridwidth = 1;
		gc.gridy++;
		panelScoreEtVote5.add(btnMin5, gc);
		gc.gridx++;
		panelScoreEtVote5.add(btnPlus5, gc);

		JPanel wraperLeft = new JPanel(new BorderLayout());

		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.add(Box.createRigidArea(new Dimension(0, 10)));
		p.add(panelScoreEtVote1);
		p.add(Box.createRigidArea(new Dimension(0, 40)));
		p.add(panelScoreEtVote2);
		p.add(Box.createRigidArea(new Dimension(0, 30)));
		p.add(panelScoreEtVote3);
		p.add(Box.createRigidArea(new Dimension(0, 30)));
		p.add(panelScoreEtVote4);
		p.add(Box.createRigidArea(new Dimension(0, 30)));
		p.add(panelScoreEtVote5);

		wraperLeft.add(p, BorderLayout.EAST);

		JButton back = new JButton("<");
		back.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SuperNoteIhm notes = new SuperNoteIhm(cours);
				Main.Instance.switchFrame(notes);

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

		JButton btnShare1 = new JButton("use");
		JButton btnShare2 = new JButton("use");
		JButton btnShare3 = new JButton("use");
		JButton btnShare4 = new JButton("use");
		JButton btnShare5 = new JButton("use");
		btnShare1.setMargin(new java.awt.Insets(0, 2, 0, 3));
		btnShare2.setMargin(new java.awt.Insets(0, 2, 0, 3));
		btnShare3.setMargin(new java.awt.Insets(0, 2, 0, 3));
		btnShare4.setMargin(new java.awt.Insets(0, 2, 0, 3));
		btnShare5.setMargin(new java.awt.Insets(0, 2, 0, 3));
		btnShare1.setFocusable(false);
		btnShare2.setFocusable(false);
		btnShare3.setFocusable(false);
		btnShare4.setFocusable(false);
		btnShare5.setFocusable(false);

		ActionListener actionSelectPourSaNote = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ToastMessage toastMessage = new ToastMessage("Cette partie a bien été sélectionée pour votre note",
						3000);
				toastMessage.setVisible(true);
			}
		};

		btnShare1.addActionListener(actionSelectPourSaNote);
		btnShare2.addActionListener(actionSelectPourSaNote);
		btnShare3.addActionListener(actionSelectPourSaNote);
		btnShare4.addActionListener(actionSelectPourSaNote);
		btnShare5.addActionListener(actionSelectPourSaNote);
		
		JLabel name1 = new JLabel("de \"Jean\"");
		JLabel name2 = new JLabel("de \"Luc\"");
		JLabel name3 = new JLabel("de \"Marie\"");
		JLabel name4 = new JLabel("de \"Jo\"");
		JLabel name5 = new JLabel("de \"Léo\"");
		
		

		JPanel pShare = new JPanel();
		pShare.setLayout(new BoxLayout(pShare, BoxLayout.Y_AXIS));
		pShare.add(Box.createRigidArea(new Dimension(0, 16)));
		pShare.add(btnShare1);
		pShare.add(name1);
		pShare.add(Box.createRigidArea(new Dimension(0, 86)));
		pShare.add(btnShare2);
		pShare.add(name2);
		pShare.add(Box.createRigidArea(new Dimension(0, 95)));
		pShare.add(btnShare3);
		pShare.add(name3);
		pShare.add(Box.createRigidArea(new Dimension(0, 95)));
		pShare.add(btnShare4);
		pShare.add(name4);
		pShare.add(Box.createRigidArea(new Dimension(0, 95)));
		pShare.add(btnShare5);
		pShare.add(name5);

		wraperRight.add(pShare, BorderLayout.WEST);

		this.add(wraperRight, BorderLayout.EAST);

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
