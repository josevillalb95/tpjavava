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

	private JFrame frmScrum = new JFrame();
	private JPanel panel = new JPanel();
	private Index index = new Index();
	private ABMSprints abms = new ABMSprints();
	private ABMTareas abmt = new ABMTareas();
	private AdminSprints admins = new AdminSprints();
	private CardLayout cl = new CardLayout();
	
	private static InterfazGrafica instance = null;

	/**
	 * Launch the application.
	 */
	public void start() {
		try {
			frmScrum.setVisible(true);
			panel.setVisible(true);
			frmScrum.setLocationRelativeTo(null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void abrirIndex() {
		frmScrum.remove(panel);
		panel = index;
		
		frmScrum.getContentPane().add(panel);
		frmScrum.revalidate();
	}

	public void abrirABMSprint(){
		
		frmScrum.remove(panel);
		panel = abms;
		abms.HidePanelAM();
		
		frmScrum.getContentPane().add(panel);
		frmScrum.revalidate();
	}
	
	public void abrirABMSTareas(){
			
			frmScrum.remove(panel);
			panel = abmt;
			
			frmScrum.getContentPane().add(panel);
			frmScrum.revalidate();
		}
	
	public void abrirAdminSprints(){
		frmScrum.remove(panel);
		panel = admins;
		
		frmScrum.getContentPane().add(panel);
		frmScrum.revalidate();
		admins.cargarTablas();
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
		frmScrum.setTitle("Scrum");
		frmScrum.setBounds(100, 100, 551, 390);
		frmScrum.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frmScrum.getContentPane().setLayout(cl);
		panel = index;
		frmScrum.getContentPane().add(panel);
		
		
		/*frame.add(panel);
		panel.add(index);
		panel.add(abms);*/
		
		//index.setVisible(true);
		
	}


}
