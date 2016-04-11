import java.awt.BorderLayout;

import javax.swing.JEditorPane;
import javax.swing.JPanel;

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
		ep.setText("<script src=\"//cdn.ckeditor.com/4.5.8/full/ckeditor.js\"></script>");
		this.add(ep, BorderLayout.CENTER);
	}
}
