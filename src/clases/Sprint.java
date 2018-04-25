package clases;

import java.util.TreeSet;


public class Sprint implements Comparable<Sprint>{
	
	private	String clave, descripcion;
	private EstadoSprint estado;
	private TreeSet<Tarea> LTareas;
	
	public Sprint(String clave, String descripcion, EstadoSprint estado, TreeSet<Tarea> lTareas) {
		super();
		this.clave = clave;
		this.descripcion = descripcion;
		this.estado = estado;
		LTareas = lTareas;
	}
	
	
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public int compareTo(Sprint arg0) {
		// TODO Auto-generated method stub
		
		return this.clave.compareTo(arg0.getClave());
	}
	
}
