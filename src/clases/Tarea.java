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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public int getComplejidad() {
		return complejidad;
	}

	public boolean equals(Tarea obj) {
		if (id.equals(obj.getId()))
			return true;
		else
			return false;
	}
	
	public void muestraHistorico(){
		Iterator<Estado> it = Lhist.iterator();
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
