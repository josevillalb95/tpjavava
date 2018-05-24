package UI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public final class Index extends JPanel {

	/**
	 * Create the panel.
	 */
	public Index() {
		setLayout(null);
		
		JButton btnABMSprints = new JButton("ABM Sprints");
		btnABMSprints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazGrafica.getInstance().abrirABMSprint();
				
			}
		});
		btnABMSprints.setBounds(268, 80, 116, 23);
		add(btnABMSprints);
		
		JButton btnABMTareas = new JButton("ABM Tareas");
		btnABMTareas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterfazGrafica.getInstance().abrirABMSTareas();
			}
		});
		btnABMTareas.setBounds(268, 151, 116, 23);
		add(btnABMTareas);
		
		JButton btnAdmin = new JButton("Administracion");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterfazGrafica.getInstance().abrirAdminSprints();
			}
		});
		btnAdmin.setBounds(268, 218, 116, 23);
		add(btnAdmin);

	}
}
