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

import backLogs.Backlog;
import clases.Proyecto;
import clases.SprintNoValido;

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
		table.setAutoscrolls(true);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accion = 1;
				panelAM.setVisible(true);
			}
		});
		btnAgregar.setBounds(350, 50, 89, 23);
		add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					accion = 2;
					panelAM.setVisible(true);
					txtClave.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
					txtClave.setEnabled(false);
					txtDescripcion.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
					table.setEnabled(false);
					btnModificar.setEnabled(false);
				}catch(ArrayIndexOutOfBoundsException e){
					JOptionPane.showMessageDialog(null, "Debe existir seleccionar un Sprint a modificar.", "Error", JOptionPane.ERROR_MESSAGE);
					panelAM.setVisible(false);
				}
			}
		});
		btnModificar.setBounds(350, 109, 89, 23);
		add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				Proyecto.getInstance().bajaSprint(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
				}
				catch(ArrayIndexOutOfBoundsException e){
					JOptionPane.showMessageDialog(null, "Debe existir seleccionar un Sprint a eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (SprintNoValido e) {
					JOptionPane.showMessageDialog(null, "No se pueden eliminar los Sprints EN CURSO o FINALIZADO.", "Error", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
				table.setModel(new SprintsTM(Proyecto.getInstance().getLSprints()));
			}
		});
		btnEliminar.setBounds(350, 174, 89, 23);
		add(btnEliminar);
		
		JLabel lblSprints = new JLabel("Sprints");
		lblSprints.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSprints.setBounds(66, 1, 127, 25);
		add(lblSprints);
		
		JButton bBack = new JButton("<-");
		bBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterfazGrafica.getInstance().abrirIndex();
			}
		});
		bBack.setBounds(10, 3, 46, 23);
		add(bBack);
		
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
				if(accion==1){
					Proyecto.getInstance().altaSprint(txtClave.getText(), txtDescripcion.getText());
					JOptionPane.showMessageDialog(null, "Sprint agregado con exito.");
				}
				else
					if (accion ==2){
						table.setEnabled(true);
						txtClave.setEnabled(true);
						Proyecto.getInstance().modificacionSprint(txtClave.getText(), txtDescripcion.getText());
						JOptionPane.showMessageDialog(null, "Sprint modificado con exito.");
						btnModificar.setEnabled(true);
					}
				table.setModel(new SprintsTM(Proyecto.getInstance().getLSprints()));
				Proyecto.getInstance().corrersp();
				LimpiaCampos();
				panelAM.setVisible(false);	
				
				accion = 0;
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiaCampos();
				panelAM.setVisible(false);
				txtClave.setEnabled(true);
				}
		});
		panelAM.add(btnCancelar);
		
	}
	
	public void HidePanelAM(){
		panelAM.setVisible(false);
	}
	
	public void LimpiaCampos(){
		txtClave.setText(null);
		txtDescripcion.setText(null);
	}
}
