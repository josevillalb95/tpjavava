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
	
	/**
	 * Retorna la clave del Sprint.
	 * @return clave
	 */
	public String getClave() {
		return clave;
	}
	public TreeSet<Tarea> getListaT() {
		return LTareas;
	}
	
	public EstadoSprint getEstado() {
		return estado;
	}
	
	/**
	 * Modifica el valor de la clave del Sprint.
	 * @param clave
	 */

	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * Permite la comparación entre dos Sprints
	 * utilizando la clave para ordenarlos por
	 * orden alfabético.
	 * 
	 */
	@Override
	public int compareTo(Sprint arg0) {		
		return this.clave.compareTo(arg0.getClave());
	}
	
	/**
	 * Comienza el Sprint, indicando
	 * cual es la fecha de inicio y la de fin.
	 * @param fi
	 * @param ff
	 */
	
	public void comenzar(Date fi,Date ff){
		estado = EstadoSprint.ENCURSO;
		fInicio = fi;
		fFin = ff;
		//Cantidad de dias de duracion y avance no se saca automaticamente?
	}
	
	/**
	 * Finaliza el Sprint.
	 */
	
	public void finalizar(){
		estado = EstadoSprint.FINALIZADO;
		//Trasladar Sprints sin terminar
	}
	
}
