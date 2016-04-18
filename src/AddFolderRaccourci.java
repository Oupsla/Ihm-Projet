import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

public class AddFolderRaccourci implements KeyListener {

	
		private FolderIhm panel;
	    private final Set<Integer> pressed = new HashSet<Integer>();
	    public AddFolderRaccourci(FolderIhm panel) {
	    	this.panel = panel;
	    }
	    public synchronized void keyPressed(KeyEvent e) {
	        pressed.add(e.getKeyCode());
	        if (pressed.size() > 1) {
	        	if(pressed.contains(KeyEvent.VK_CONTROL) && 
	        	   pressed.contains(KeyEvent.VK_A)) {
	        		panel.addFolder();
	        	}
	        }
	    }

	    public synchronized void keyReleased(KeyEvent e) {
	        pressed.remove(e.getKeyChar());
	    }

	    public void keyTyped(KeyEvent e) {/* Not used */ }
	}
