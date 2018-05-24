package UI;

import javax.swing.JPanel;
import javax.swing.JTable;

import clases.Proyecto;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class AdminSprints extends JPanel {
	private JTable tableTareas;
	private JTable tableSubtareas;

	/**
	 * Create the panel.
	 */
	public AdminSprints() {
		setLayout(null);
		
		JButton button = new JButton("<-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazGrafica.getInstance().abrirIndex();
			}
		});
		button.setBounds(10, 11, 46, 23);
		add(button);
		
		JButton btnDiaSiguiente = new JButton("Dia Siguiente");
		btnDiaSiguiente.setBounds(180, 59, 95, 23);
		add(btnDiaSiguiente);
		
		JLabel lblDia = new JLabel("New label");
		lblDia.setBounds(202, 38, 46, 14);
		add(lblDia);
		
		tableTareas = new JTable();
		tableTareas.setBounds(10, 112, 251, 154);
		add(tableTareas);		
		
		tableSubtareas = new JTable();
		tableSubtareas.setBounds(271, 112, 169, 177);
		add(tableSubtareas);
		
		JLabel lblNombreSprint = new JLabel("Nombre sprint:");
		lblNombreSprint.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombreSprint.setBounds(10, 97, 93, 14);
		add(lblNombreSprint);
		
		JLabel lblSprint = new JLabel("Sprint");
		lblSprint.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSprint.setBounds(113, 98, 135, 14);
		add(lblSprint);
		
		JLabel lblAdministracionSprints = new JLabel("ADMINISTRACION SPRINTS");
		lblAdministracionSprints.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblAdministracionSprints.setBounds(113, 13, 221, 14);
		add(lblAdministracionSprints);
		
		JButton btnNewButton = new JButton("Estado Ant");
		btnNewButton.setBounds(10, 277, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Estado Sig");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setBounds(172, 277, 89, 23);
		add(btnNewButton_1);

	}
	
	public void cargarTablas(){
		tableTareas.setModel(new TareasSprintTM(Proyecto.getInstance().getTareasSprintEnCurso()));
	}
}
