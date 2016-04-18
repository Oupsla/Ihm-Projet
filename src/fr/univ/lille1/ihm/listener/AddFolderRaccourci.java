package fr.univ.lille1.ihm.listener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;
import fr.univ.lille1.ihm.panel.FolderIhm;

public class AddFolderRaccourci implements KeyListener {

	
		private FolderIhm panel;
	    private final Set<Integer> pressed = new HashSet<Integer>();
	    private boolean haveRelease;
	    public AddFolderRaccourci(FolderIhm panel) {
	    	this.panel = panel;
	    	haveRelease = true;
	    }
	    public synchronized void keyPressed(KeyEvent e) {
	        pressed.add(e.getKeyCode());
	        if (pressed.size() > 1) {
	        	if(pressed.contains(KeyEvent.VK_CONTROL) && 
	        	   pressed.contains(KeyEvent.VK_A) && haveRelease) {
	        		panel.addFolder();
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
