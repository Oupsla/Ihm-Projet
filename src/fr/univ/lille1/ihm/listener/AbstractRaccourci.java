package fr.univ.lille1.ihm.listener;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/**
 * Classe à hériter pour faire des raccourcis ; en exemple AddFolderRaccourci()
 * @author Jo
 *
 */
public abstract class AbstractRaccourci implements KeyListener {
	
    private final Set<Integer> pressed = new HashSet<Integer>();
    private final Set<Integer> haveToBePressed = new HashSet<Integer>();
    private boolean haveRelease;
    private Method method;
    private Component component;
    /**
     * 
     * @param component le composant sur lequel vous ajoutez le keyListener. Attention il faut que setFocusable soit à true
     * Appeller donc component.setFocusable(true); avant l'ajout du listener
     * @param methodName le nom de votre methode de modification. Pour un rafraichissement du panel =>
     * panel.validate(); panel.repaint(); à la fin de votre méthode
     * @param keyEventCode les keyEvent a pressé pour votre raccourcis. Disponible en static via KeyEvent.VK_XXX
     */
    public AbstractRaccourci(Component component, String methodName, Integer...keyEventCode) {
    	haveToBePressed.addAll(Arrays.asList(keyEventCode));
    	try {
    		this.component = component;
    		this.method = component.getClass().getMethod(methodName);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
    	haveRelease = true;
    }
    public synchronized void keyPressed(KeyEvent e) {
        pressed.add(e.getKeyCode());
        if (pressed.size() > 1) {
        	if(pressed.containsAll(haveToBePressed) && 
        	   haveRelease) {
        		try {
					method.invoke(component);
				} catch (IllegalAccessException e1) {
					
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					e1.printStackTrace();
				}
        		pressed.clear();
        		haveRelease = false;
        	}
        }
    }

    public synchronized void keyReleased(KeyEvent e) {
    	if(pressed.contains(e.getKeyChar()))
    		pressed.remove(e.getKeyChar());
        haveRelease = true;
    }

    public void keyTyped(KeyEvent e) {/* Not used */ }
}
