package fr.univ.lille1.ihm.listener;
import java.awt.Component;
import java.awt.event.KeyEvent;
/**
 * Raccourci Ctrl + A pour la page d'acc.
 * @author Jo
 *
 */
public class AddFolderRaccourci extends AbstractRaccourci {

	private final static String methodName = "addFolder";
	public AddFolderRaccourci(Component component) {
		super(component, methodName, KeyEvent.VK_CONTROL,KeyEvent.VK_A);
	}
}
