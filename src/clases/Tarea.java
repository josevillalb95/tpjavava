package clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import estadosTareas.Estado;

public class Tarea implements Comparable<Tarea> {

	private String id, nombre, descripcion;
	private Date fFin;
	private Estado estado;
	private ArrayList<Estado> Lhist; //Podria ser un Treeset para ordenarlos por fecha?
	private int complejidad;
	//El listado de 0 o mas subtareas no seria las dependencias?
	private int estimacion; //Conviene sacar valor en Constructor o en otra funcion?
	//No entendi muy bien como obtener estimacion
	
	public Tarea(String id, String nombre, String descripcion, Date finalizacion, Estado estado,
			int complejidad) {
		super();
		this.id = id;
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
	public Estado getEstado() {
		return estado;
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
