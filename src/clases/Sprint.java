package clases;

import java.util.Date;
import java.util.TreeSet;


public class Sprint implements Comparable<Sprint>{
	
	private	String clave, descripcion;
	private EstadoSprint estado;
	private Date fInicio,fFin;
	private TreeSet<Tarea> LTareas;
	
	public Sprint(String clave, String descripcion, EstadoSprint estado, TreeSet<Tarea> lTareas) {
		super();
		this.clave = clave;
		this.descripcion = descripcion;
		this.estado = estado;
		this.LTareas = lTareas;
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
	
	public void comenzar(Date fi,Date ff){
		estado = EstadoSprint.ENCURSO;
		fInicio = fi;
		fFin = ff;
		//Cantidad de dias de duracion y avance no se saca automaticamente?
	}
	
	public void finalizar(){
		estado = EstadoSprint.FINALIZADO;
		//Trasladar Sprints sin terminar
	}
	
}
