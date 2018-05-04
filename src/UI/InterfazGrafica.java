package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public final class InterfazGrafica {

	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private Index index = new Index();
	private ABMSprints abms = new ABMSprints();
	private CardLayout cl = new CardLayout();
	
	private static InterfazGrafica instance = null;

	/**
	 * Launch the application.
	 */
	public void start() {
		try {
			frame.setVisible(true);
			panel.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void abrirIndex() {
		frame.remove(panel);
		panel = index;
		
		frame.add(panel);
		frame.revalidate();
	}

	public void abrirABMSprint(){
		
		frame.remove(panel);
		panel = abms;
		
		frame.add(panel);
		frame.revalidate();
	}
	
	/**
	 * Create the application.
	 */
	private InterfazGrafica() {
		initialize();
		
	}

	public static InterfazGrafica getInstance(){
		
		if (instance == null)
			instance = new InterfazGrafica(); 
		
		return instance; 
		
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setBounds(100, 100, 551, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(cl);
		panel = index;
		frame.add(panel);
		
		
		/*frame.add(panel);
		panel.add(index);
		panel.add(abms);*/
		
		//index.setVisible(true);
		
	}


}
