/**
 * 
 */
package UI;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.swing.table.AbstractTableModel;

import Tareas.Tarea;

/**
 * @author tomi_
 *
 */
public class TareasSprintTM extends AbstractTableModel{
	private List<Tarea> aTareas;

	public TareasSprintTM(TreeSet<Tarea> lista) {
		aTareas = new ArrayList<>(lista);
	}

	public int getColumnCount() {
		return 5;
	}

	public int getRowCount() {
		return aTareas.size();
	}
	
	public void setaTareas(TreeSet<Tarea> aTareas) {
		this.aTareas = new ArrayList<>(aTareas);
	}

	public Object getValueAt(int row, int column) {
		Tarea tar = aTareas.get(row);
		Object ob = null;
		switch (column) {
		case 0:
			ob = tar.getId();
			break;
		case 1:
			ob = tar.getDescripcion();
			break;
		case 2:
			ob = tar.getEstado();
			break;
		}
		return ob;
	}

}
