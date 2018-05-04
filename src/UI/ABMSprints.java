package UI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import clases.Proyecto;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ABMSprints extends JPanel {
	private JTable table;
	private JTextField txtClave;
	private JTextField txtDescripcion;
	private int accion = 0;

	/**
	 * Create the panel.
	 */
	public ABMSprints() {
		setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 31, 330, 191);
		add(table);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accion = 1;
				txtClave.setEnabled(true);
			}
		});
		btnAgregar.setBounds(350, 50, 89, 23);
		add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(350, 109, 89, 23);
		add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(350, 174, 89, 23);
		add(btnEliminar);
		
		JLabel lblSprints = new JLabel("Sprints");
		lblSprints.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSprints.setBounds(66, 1, 127, 25);
		add(lblSprints);
		
		txtClave = new JTextField();
		txtClave.setBounds(51, 233, 86, 20);
		add(txtClave);
		txtClave.setColumns(10);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setBounds(20, 236, 46, 14);
		add(lblClave);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(207, 233, 133, 20);
		add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(148, 236, 75, 14);
		add(lblDescripcion);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Proyecto.getInstance().altaSprint(txtClave.getText(), txtDescripcion.getText());
			}
		});
		btnAceptar.setBounds(350, 232, 75, 23);
		add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(350, 266, 75, 23);
		add(btnCancelar);
		
		JButton button = new JButton("<-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterfazGrafica.getInstance().abrirIndex();
			}
		});
		button.setBounds(10, 3, 46, 23);
		add(button);
		
	}
}
