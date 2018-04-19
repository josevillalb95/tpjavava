/**
 * 
 */
package clases;

import java.util.Comparator;

/**
 * @author tomi_
 *
 */
public class Tarea implements Comparable, Comparator{

	private String id, nombre, descripcion, ffinalizacion;
	private EstadoTarea estado;
	//Historico
	private int complejidad;
	//Dependencias
	//Listado de sub tareas (como hacer que estas no tengan subtareas?)
	
	
	public Tarea(String id, String nombre, String descripcion, String ffinalizacion, EstadoTarea estado,
			int complejidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.ffinalizacion = ffinalizacion;
		this.estado = estado;
		this.complejidad = complejidad;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	public int compareTo(Tarea arg0) {
		// TODO Auto-generated method stub
		return id.compareTo(arg0.id); //Esta bien esto?
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean equals(Tarea obj) {
		if(id.equals(obj.getId()))
			return true;
		else
			return false;
	}

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
