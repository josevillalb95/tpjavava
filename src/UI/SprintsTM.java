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
		setValueAt("Clave", 0, 1);
	}
	
	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
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