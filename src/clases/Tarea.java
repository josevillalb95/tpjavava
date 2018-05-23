package clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

import estadosTareas.Estado;
import estadosTareas.ToDo;

public class Tarea implements Comparable<Tarea> {

	private String id, nombre, descripcion;
	private Date fFin;
	private Estado estado;
	private ArrayList<Estado> Lhist; //Podria ser un Treeset para ordenarlos por fecha?
	private int complejidad;
	private TreeSet<Tarea> LSTareas;
	private int estimacion; //Conviene sacar valor en Constructor o en otra funcion?
	private TreeSet<Tarea> Ldependencias;
	private TreeSet<Tarea> LSubtareas;
	
	public Tarea(String id, String nombre, String descripcion, Date finalizacion,
			int complejidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fFin = finalizacion;
		//this.estado = new ToDo();
		this.LSTareas = null;
		this.complejidad = complejidad;
		Lhist =null;
	}
	public TreeSet<Tarea> getListaS() {
		return LSTareas;
	}
	public void aBacklogTarea(Tarea tare) {
		LSTareas.add(tare);
	}
	
	public TreeSet<Tarea> getLdependencias() {
		return Ldependencias;
	}
	/**
	 * 
	 * @param clave
	 * @param tare
	 * Modifica el valor de la clave del backglog.
	 * FALTA EL ESTADO :o !!! 
	 */
	public void mBacklogTarea(String clave , Tarea tare) {
		for(Tarea c:LSTareas ){
			if(c.getId().equals(clave)){
				if(c.getEstado() != "finalizado" )
					c.modTarea(tare.getNombre(),tare.getDescripcion() ,tare.getfFin(), tare.getEstado(), tare.getComplejidad());
			c.getDescripcion();
			}
		}
	}
	/**
	 * 
	 * @param clave
	 * elimina un nodo del treeset que concida con la clave enviada 
	 */
	public void bSprintTarea(String clave , Tarea tare) {
		for(Tarea c:LSTareas ){
				LSTareas.remove(c); 
		}
	}
	
	
	public void modTarea( String nombre, String descripcion, Date finalizacion, Estado estado,int complejidad) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fFin = finalizacion;
		this.estado = estado;
		this.complejidad = complejidad;
		Lhist = new ArrayList<>();
	}
	
	
	public String getNombre() {
		return nombre;
	}


	 
	public String getDescripcion() {
		return descripcion;
	} 
	public Date getfFin() {
		return fFin;
	} 
	public String getEstado() {
		return estado.toString();
	}
 
	public ArrayList<Estado> getLhist() {
		return Lhist;
	}

 
	public int getEstimacion() {
		return estimacion;
	}
	
	public void TareaMOD(String nombre, String descripcion, Date finalizacion, Estado estado,int complejidad) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fFin = finalizacion;
		this.estado = estado;
		this.complejidad = complejidad;
	}
	/**
	 * Retorna el id de la Tarea.
	 * @return id
	 */

	public String getId() {
		return id;
	}
	
	/**
	 * Modifica el id de la Tarea.
	 * @param id
	 */

	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Retorna complejidad de la Tarea.
	 * @return complejidad
	 */
	
	public int getComplejidad() {
		return complejidad;
	}
	
	/**
	 * Compara dos Tareas.
	 * Retorna True si son iguales.
	 * Retorna False si son diferentes.
	 * @param obj
	 * @return true || false
	 */

	public boolean equals(Tarea obj) {
		if (id.equals(obj.getId()))
			return true;
		else
			return false;
	}
	
	/**
	 * Muestra los datos de los pasos que realizó la tarea
	 * hasta el punto actual.
	 */
	
	public void muestraHistorico(){
		Iterator<Estado> it = Lhist.iterator();
		while (it.hasNext()){
			System.out.println(it.next().toString() + "\n");
		}		
	}
	

	/**
	 * Permite la comparación entre una Tarea y 
	 * la Tarea actual.
	 * param @arg0 	
	 */
	@Override
	public int compareTo(Tarea arg0) {
		return this.id.compareTo(arg0.getId());
	}

	/*
	 * @Override public int compare(Object o1, Object o2) { // TODO
	 * Auto-generated method stub return 0; }
	 */

}
