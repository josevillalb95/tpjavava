package clases;

import java.util.Date;
import java.util.TreeSet;
import java.time.LocalDate;

public class Sprint implements Comparable<Sprint>{
	
	private	String clave, descripcion;
	private EstadoSprint estado;
	private LocalDate fInicio , fFin;
	private TreeSet<Tarea> LTareas;
	
	public Sprint(String clave, String descripcion) {
		this.clave = clave;
		this.descripcion = descripcion;
		this.estado = EstadoSprint.PLANIFICADO;
		this.LTareas = null;
	}
	
	/**
	 * Retorna la clave del Sprint.
	 * @return clave
	 */
	public String getClave() {
		return clave;
	}
	public void actualizar(String clave, String descripcion, EstadoSprint estado, TreeSet<Tarea> lTareas) {
		this.clave = clave;
		this.descripcion = descripcion;
		this.estado = estado;
		this.LTareas = lTareas;
	}

	public TreeSet<Tarea> getListaT() {
		return LTareas;
	}
	
	public EstadoSprint getEstado() {
		return estado;
	}
	public void setEstadoSprint(EstadoSprint estado) {
		this.estado = estado;
	}
	public String getdescripcion() {
		return descripcion;
	}
	
	/**
	 * 
	 * @param tarea treeset que se va agregar a tareas
	 */
	public void aSprintTarea(Tarea tare) {
		LTareas.add(tare);
	}
	

	/**
	 * 
	 * @param clave
	 * @param tare
	 * Modifica el valor de la clave del Sprint.
	 * FALTA EL ESTADO :o !!! 
	 */
	public void mSprintTarea(String clave , Tarea tare) {
		for(Tarea c:LTareas ){
			if(c.getId().equals(clave)){
				if(c.getEstado() != "finalizado" )
					c.modTarea(tare.getNombre(),tare.getDescripcion() ,tare.getfFin(), tare.getEstado(), tare.getComplejidad());
			}
		}
		
	}
	
	
	/**
	 * 
	 * @param clave
	 * elimina un nodo del treeset que concida con la clave enviada 
	 */
	public void bSprintTarea(String clave , Tarea tare) {
		for(Tarea c:LTareas ){
			if(c.getId().equals(clave)){
				LTareas.remove(c);
			}
		}
	}
	

	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * Permite la comparación entre dos Sprints
	 * utilizando la clave para ordenarlos por
	 * orden alfabético.
	 * 
	 */
	public int compareTo(Sprint arg0) {		
		return this.clave.compareTo(arg0.getClave());
	}
	
	public LocalDate getFechaFin(){
		return fFin;
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
