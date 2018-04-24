package clases;


/**
 * @author tomi_
 *
 */
public class Tarea implements Comparable<Tarea>{

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
	
	public boolean equals(Tarea obj) {
		if(id.equals(obj.getId()))
			return true;
		else
			return false;
	}

	@Override
	public int compareTo(Tarea arg0) {
		return this.id.compareTo(arg0.getId());
	}

	/*@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}*/
	
}
