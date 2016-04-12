import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

/**
 * 
 * Classe representant une note de cours
 * 
 * Doit apparaitre :
 *  - Plusieurs sections sur la note (titre, introduction, 1ere partie, ...)
 *  - Une fleche sur le cote droit pour acceder à la superNote
 *  - Un bouton minimiser sur chaque sections pour miniser la partie
 *  (celle-ci apparait donc sous une autre forme avec par exemple le debut de la section
 *  suivi de 3 petits points)
 *  - Un bouton permettant de partager une section
 *  - Un bouton permettant de partager toute sa note
 * 
 */
public class NoteIhm extends JPanel{

	public NoteIhm(){
		this.setLayout(new BorderLayout());
		JEditorPane ep = new JEditorPane();
		ep.setContentType("text/html");
		ep.setText("<h1>\r\n\tQu\u2019apporte SwingStates ?\r\n</h1>\r\n\r\n<p>\r\n\tSwingStates permet de programmer l\u2019interaction en la d\u00E9crivant \u00E0\r\n\tl\u2019aide de machines \u00E0 \u00E9tats\r\n</p>\r\n<ul>\r\n\t<li>les machines sont sp\u00E9cifi\u00E9es en Java, au milieu du reste du code</li>\r\n\t<li>elles peuvent ensuite \u00EAtre attach\u00E9es \u00E0 un widget</li>\r\n</ul>\r\n<p>\r\nSwingStates fournit un canevas pour le dessin 2D\r\n</p>\r\n<ul>\r\n\t<li>les formes \u00E0 afficher sont ajout\u00E9es une \u00E0 une au canevas</li>\r\n\t<li>pour chacune d\u2019elle, on peut sp\u00E9cifier la g\u00E9om\u00E9trie, des attributs\r\ngraphiques, un parent et des tags</li>\r\n\t<li>SwingStates s\u2019occupe de l\u2019affichage et de la s\u00E9lection (picking), des\r\nanimations</li>\r\n</ul>\r\n<p>\r\n\tSwingStates int\u00E8gre aussi deux reconnaisseurs de gestes, mais c\u2019est\r\nune autre histoire\u2026\r\n</p>\r\n<p>\r\nSwingStates is a library that adds state machines to the Java Swing user interface toolkit. Unlike traditional approaches, which use callbacks or listeners to define interaction, state machines provide a powerful control structure and localize all of the interaction code in one place. SwingStates takes advantage of Java's inner classes, providing programmers with a natural syntax and making it easier to follow and debug the resulting code. SwingStates tightly integrates state machines, the Java language and the Swing toolkit. It reduces the potential for an explosion of states by allowing multiple state machines to work together. SwingStates can be used to add new interaction techniques to existing Swing widgets, to program new widgets by using the flexible and powerful SwingStates' Canvas and to control high-level dialogues.\r\n</p>\r\n");
		this.add(ep, BorderLayout.CENTER);
		
		JButton expand1 = new JButton("-");
		expand1.setMargin(new java.awt.Insets(0, 2, 0, 3));
		expand1.setFocusable(false);
		
		expand1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (expand1.getText().equals("+")){
					expand1.setText("-");
					expand1.setMargin(new java.awt.Insets(0, 2, 0, 3));
					ep.setText("<h1>\r\n\tQu\u2019apporte SwingStates ?\r\n</h1>\r\n\r\n<p>\r\n\tSwingStates permet de programmer l\u2019interaction en la d\u00E9crivant \u00E0\r\n\tl\u2019aide de machines \u00E0 \u00E9tats\r\n</p>\r\n<ul>\r\n\t<li>les machines sont sp\u00E9cifi\u00E9es en Java, au milieu du reste du code</li>\r\n\t<li>elles peuvent ensuite \u00EAtre attach\u00E9es \u00E0 un widget</li>\r\n</ul>\r\n<p>\r\nSwingStates fournit un canevas pour le dessin 2D\r\n</p>\r\n<ul>\r\n\t<li>les formes \u00E0 afficher sont ajout\u00E9es une \u00E0 une au canevas</li>\r\n\t<li>pour chacune d\u2019elle, on peut sp\u00E9cifier la g\u00E9om\u00E9trie, des attributs\r\ngraphiques, un parent et des tags</li>\r\n\t<li>SwingStates s\u2019occupe de l\u2019affichage et de la s\u00E9lection (picking), des\r\nanimations</li>\r\n</ul>\r\n<p>\r\n\tSwingStates int\u00E8gre aussi deux reconnaisseurs de gestes, mais c\u2019est\r\nune autre histoire\u2026\r\n</p>\r\n<p>\r\nSwingStates is a library that adds state machines to the Java Swing user interface toolkit. Unlike traditional approaches, which use callbacks or listeners to define interaction, state machines provide a powerful control structure and localize all of the interaction code in one place. SwingStates takes advantage of Java's inner classes, providing programmers with a natural syntax and making it easier to follow and debug the resulting code. SwingStates tightly integrates state machines, the Java language and the Swing toolkit. It reduces the potential for an explosion of states by allowing multiple state machines to work together. SwingStates can be used to add new interaction techniques to existing Swing widgets, to program new widgets by using the flexible and powerful SwingStates' Canvas and to control high-level dialogues.\r\n</p>\r\n");
				}
				else{
					expand1.setText("+");
					expand1.setMargin(new java.awt.Insets(0, 0, 0, 0));
					ep.setText("<h1>\r\n\tQu\u2019apporte SwingStates ?\r\n</h1>\r\n\r\n<p>\r\n\tSwingStates permet de programmer l\u2019interaction en la d\u00E9crivant \u00E0\r\n\tl\u2019aide de machines \u00E0 \u00E9tats\r\n\t<hr>\r\n</p>\r\n<p>\r\nSwingStates fournit un canevas pour le dessin 2D\r\n</p>\r\n<ul>\r\n\t<li>les formes \u00E0 afficher sont ajout\u00E9es une \u00E0 une au canevas</li>\r\n\t<li>pour chacune d\u2019elle, on peut sp\u00E9cifier la g\u00E9om\u00E9trie, des attributs\r\ngraphiques, un parent et des tags</li>\r\n\t<li>SwingStates s\u2019occupe de l\u2019affichage et de la s\u00E9lection (picking), des\r\nanimations</li>\r\n</ul>\r\n<p>\r\n\tSwingStates int\u00E8gre aussi deux reconnaisseurs de gestes, mais c\u2019est\r\nune autre histoire\u2026\r\n</p>\r\n\r\n<p>\r\nSwingStates is a library that adds state machines to the Java Swing user interface toolkit. Unlike traditional approaches, which use callbacks or listeners to define interaction, state machines provide a powerful control structure and localize all of the interaction code in one place. SwingStates takes advantage of Java's inner classes, providing programmers with a natural syntax and making it easier to follow and debug the resulting code. SwingStates tightly integrates state machines, the Java language and the Swing toolkit. It reduces the potential for an explosion of states by allowing multiple state machines to work together. SwingStates can be used to add new interaction techniques to existing Swing widgets, to program new widgets by using the flexible and powerful SwingStates' Canvas and to control high-level dialogues.\r\n</p>");
				}
				
			}
		});
		
		JButton expand2 = new JButton("-");
		expand2.setMargin(new java.awt.Insets(0, 2, 0, 3));
		expand2.setFocusable(false);
		
		JButton expand3 = new JButton("-");
		expand3.setMargin(new java.awt.Insets(0, 2, 0, 3));
		expand3.setFocusable(false);
		
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.add(Box.createRigidArea(new Dimension(0,62)));
		p.add(expand1);
		p.add(Box.createRigidArea(new Dimension(0,65)));
		p.add(expand2);
		p.add(Box.createRigidArea(new Dimension(0,115)));
		p.add(expand3);
		this.add(p, BorderLayout.WEST);
	}
}
