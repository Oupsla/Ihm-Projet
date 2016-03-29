import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main {
	
	public static Main Instance;
	
	private JFrame mainFrame;
	private JPanel panelActuel;
	
	public Main() {
		
		mainFrame = new JFrame("Projet Ihm");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainFrame.getContentPane().setLayout(new FlowLayout());
		
		mainFrame.getContentPane().setSize(800,400);
		
		panelActuel = new FolderIhm();
		mainFrame.add(panelActuel);	

		mainFrame.pack();
		mainFrame.setVisible(true);
		
	
	}
	

	public void switchFrame(JPanel nextPanel){
		mainFrame.removeAll();
		panelActuel = nextPanel;
		mainFrame.add(nextPanel);
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
