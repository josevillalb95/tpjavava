/**
 * 
 */
package clases;

import java.util.Date;

import estadosTareas.Estado;

/**
 * @author tomi_
 *
 */
public class Bug extends Tarea{
	
	private Tarea dependencia;

	public Bug(String id, String nombre, String descripcion, Date finalizacion, Estado estado, int complejidad) {
		super(id, nombre, descripcion, finalizacion, estado, complejidad);
		// TODO Auto-generated constructor stub
	}
}
