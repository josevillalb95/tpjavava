package UI;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.swing.table.AbstractTableModel;

import Tareas.Tarea;



public class TareasTM extends AbstractTableModel{
	
	private List<Tareas.Tarea> aTareas;

	public TareasTM(TreeSet<Tarea> lista) {
		aTareas = new ArrayList<>(lista);
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return aTareas.size();
	}
	
	public void setaTareas(TreeSet<Tarea> aTareas) {
		this.aTareas = new ArrayList<>(aTareas);
	}

	@Override
	public Object getValueAt(int row, int column) throws ArrayIndexOutOfBoundsException {
		Tarea tar = aTareas.get(row);
		Object ob = null;
		switch (column) {
		case 0:
			ob = tar.getId();
			break;
		case 1:
			ob = tar.getNombre();
			break;
		case 2:
			ob = tar.getDescripcion();
			break;
		case 3:
			ob = tar.getEstado();
		}
		return ob;
	}

}
