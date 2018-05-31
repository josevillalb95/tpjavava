package UI;

import javax.swing.JPanel;
import javax.swing.JTable;

import clases.Proyecto;
import clases.Tarea;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ABMTareasEnSprint extends JPanel {
	private JTable table;
	private Tarea tar;

	
	
	
	/**
	 * Create the panel.
	 */
	public ABMTareasEnSprint(Tarea t) {
		setLayout(null);
		
		tar = t;
		
		table = new JTable();
		table.setBounds(10, 11, 280, 234);
		add(table);
		table.setModel(new SprintsTM(Proyecto.getInstance().getLSprints()));
		
		JButton btnAsignar = new JButton("Asignar");
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnAsignar.setBounds(104, 266, 89, 23);
		add(btnAsignar);
		
	}
}
