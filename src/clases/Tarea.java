package clases;

import java.util.ArrayList;
import java.util.Iterator;

public class Tarea implements Comparable<Tarea> {

	private String id, nombre, descripcion, finalizacion;
	private EstadoTarea estado;
	private ArrayList<EstadoTarea> historico;
	private int complejidad;
	// Dependencias
	// Listado de sub tareas (como hacer que estas no tengan subtareas?)

	public Tarea(String id, String nombre, String descripcion, String finalizacion, EstadoTarea estado,
			int complejidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.finalizacion = finalizacion;
		this.estado = estado;
		this.complejidad = complejidad;
		historico = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean equals(Tarea obj) {
		if (id.equals(obj.getId()))
			return true;
		else
			return false;
	}
	
	public void muestraHistorico(){
		Iterator<EstadoTarea> it = historico.iterator();
		while (it.hasNext()){
			System.out.println(it.next().toString() + "\n");
		}		
	}

	@Override
	public int compareTo(Tarea arg0) {
		return this.id.compareTo(arg0.getId());
	}

	/*
	 * @Override public int compare(Object o1, Object o2) { // TODO
	 * Auto-generated method stub return 0; }
	 */

}
