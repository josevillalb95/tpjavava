package UI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.sun.xml.internal.ws.api.message.Message;

import clases.Backlog;
import clases.Proyecto;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ABMSprints extends JPanel {
	private JTable table;
	private JTextField txtClave;
	private JTextField txtDescripcion;
	private int accion = 0;
	private JPanel panelAM = new JPanel();

	/**
	 * Create the panel.
	 */
	public ABMSprints() {
		setLayout(null);
				
		table = new JTable();
		table.setBounds(10, 31, 330, 191);
		add(table);
		table.setModel(new SprintsTM(Proyecto.getInstance().getLSprints()));
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accion = 1;
				panelAM.setEnabled(true);
			}
		});
		btnAgregar.setBounds(350, 50, 89, 23);
		add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				accion = 2;
				panelAM.setEnabled(true);
			}
		});
		btnModificar.setBounds(350, 109, 89, 23);
		add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Proyecto.getInstance().bajaSprint(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
			}
		});
		btnEliminar.setBounds(350, 174, 89, 23);
		add(btnEliminar);
		
		JLabel lblSprints = new JLabel("Sprints");
		lblSprints.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSprints.setBounds(66, 1, 127, 25);
		add(lblSprints);
		
		JButton button = new JButton("<-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterfazGrafica.getInstance().abrirIndex();
			}
		});
		button.setBounds(10, 3, 46, 23);
		add(button);
		
		panelAM.setBounds(10, 227, 430, 73);
		add(panelAM);
		
		JLabel lblClave = new JLabel("Clave");
		panelAM.add(lblClave);
		
		txtClave = new JTextField();
		panelAM.add(txtClave);
		txtClave.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		panelAM.add(lblDescripcion);
		
		txtDescripcion = new JTextField();
		panelAM.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		panelAM.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Proyecto.getInstance().altaSprint(txtClave.getText(), txtDescripcion.getText());
				
				table.setModel(new SprintsTM(Proyecto.getInstance().getLSprints()));
				
				JOptionPane.showMessageDialog(null, "Sprint agregado con exito.");
				Proyecto.getInstance().corrersp();
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		panelAM.add(btnCancelar);
		
	}
}
