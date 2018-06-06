package UI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;

import Tareas.EstadoTarea;
import Tareas.Tarea;
import backLogs.Backlog;
import clases.Proyecto;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

public class ABMTareas extends JPanel {
	private JTable table;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	JComboBox cbComplejidad = new JComboBox();
	JComboBox cbTipo = new JComboBox();
	JPanel panel = new JPanel();
	
	private int accion = 0;

	/**
	 * Create the panel.
	 */
	public ABMTareas() {
		setLayout(null);
		
		JButton bBack = new JButton("<-");
		bBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazGrafica.getInstance().abrirIndex();
			}
		});
		bBack.setBounds(20, 2, 46, 23);
		add(bBack);
		
		JLabel lblTareas = new JLabel("Tareas");
		lblTareas.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTareas.setBounds(76, 0, 127, 25);
		add(lblTareas);
		
		JLabel lblBacklog = new JLabel("Backlog:");
		lblBacklog.setBounds(20, 36, 46, 14);
		add(lblBacklog);
		
		table = new JTable();
		table.setBounds(20, 47, 330, 174);
		add(table);
		table.setModel(new TareasTM(Proyecto.getInstance().getBlog().getLTareasP()));
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				accion = 1;
			}
		});
		btnAgregar.setBounds(360, 89, 89, 23);
		add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					accion = 2;
					Tarea tar = Proyecto.getInstance().getBlog().getTarea(table.getValueAt(table.getSelectedRow(), 0).toString());
					txtId.setText(tar.getId());
					txtNombre.setText(tar.getNombre());
					txtDescripcion.setText(tar.getDescripcion());
					cbComplejidad.setSelectedIndex(tar.getComplejidad()-1);
					
					txtId.setEnabled(false);
					btnModificar.setEnabled(false);
					Proyecto.getInstance().getBlog().bajaTarea(tar.getId());
				}catch(ArrayIndexOutOfBoundsException ex){
					JOptionPane.showMessageDialog(null, "Debe seleccionarse una tarea a modificar.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnModificar.setBounds(360, 123, 89, 23);
		add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Proyecto.getInstance().bajaTareaBackLog(table.getValueAt(table.getSelectedRow(), 0).toString());
					table.setModel(new TareasTM(Proyecto.getInstance().getBlog().getLTareasP()));
				}catch(ArrayIndexOutOfBoundsException ex){
					JOptionPane.showMessageDialog(null, "Debe seleccionarse una tarea a eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEliminar.setBounds(360, 157, 89, 23);
		add(btnEliminar);
		
		panel.setBounds(20, 226, 430, 101);
		add(panel);
		
		JLabel lblTipo = new JLabel("Tipo");
		panel.add(lblTipo);
		
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"Tarea", "Bug", "Historia", "Mejora"}));
		panel.add(cbTipo);
		
		JLabel lblComplejidad = new JLabel("Complejidad");
		panel.add(lblComplejidad);
		
		cbComplejidad.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		panel.add(cbComplejidad);
		
		JLabel lblId = new JLabel("Id");
		panel.add(lblId);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		panel.add(txtId);
		
		JLabel lblNombre = new JLabel("Nombre");
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		panel.add(txtNombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		panel.add(lblDescripcion);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		panel.add(txtDescripcion);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtId.setEnabled(true);
				btnModificar.setEnabled(true);
				Proyecto.getInstance().getBlog().altaTarea(cbTipo.getSelectedItem().toString(),txtId.getText(),txtNombre.getText(),txtDescripcion.getText(),EstadoTarea.DONE,null,Integer.parseInt(cbComplejidad.getSelectedItem().toString()));

				table.setModel(new TareasTM(Proyecto.getInstance().getBlog().getLTareasP()));
						
			}
		});
		panel.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar);
		
		JButton btnAsignarASprint = new JButton("Asignar a Sprint");
		btnAsignarASprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame tarensp = new JFrame();
				tarensp.setBounds(100, 100, 350, 350);
				
				ABMTareasEnSprint abmts = new ABMTareasEnSprint(Proyecto.getInstance().getBlog().getTarea(table.getValueAt(table.getSelectedRow(), 0).toString()));
				tarensp.getContentPane().add(abmts);
				tarensp.setVisible(true);
				abmts.setVisible(true);
			}
		});
		btnAsignarASprint.setBounds(352, 11, 117, 23);
		add(btnAsignarASprint);

	}
}
