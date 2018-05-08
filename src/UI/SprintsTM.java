package UI;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import org.w3c.dom.views.AbstractView;

import clases.Sprint;

public class SprintsTM extends AbstractTableModel{

	private List<Sprint> aSprints;
	
	public SprintsTM(TreeSet<Sprint> lista) {
		aSprints = new ArrayList<>(lista);
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return aSprints.size();
	}

	public void setaSprints(TreeSet<Sprint> aSprints) {
		this.aSprints = new ArrayList<>(aSprints);
	}

	@Override
	public Object getValueAt(int row, int column) {
		Sprint sp = aSprints.get(row);
		Object ob = null;
		switch (column) {
		case 0:
			ob = sp.getClave();
			break;
		case 1:
			ob = sp.getDescripcion();
			break;
		case 2:
			ob = sp.getEstado();
		}
		return ob;
	}
	
}

class Prueba implements TableModel{

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
