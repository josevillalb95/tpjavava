package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

public class InterfazGrafica {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void start() {
		try {
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public InterfazGrafica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 551, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JScrollPane Index = new JScrollPane();
		frame.getContentPane().add(Index, "name_11549577958554");
	}

}
