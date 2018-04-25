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
public class Mejora extends Tarea{
	
	//Investigar si se puede armar ArrayList de dos tipos o crear clase padre de historia y tarea

	public Mejora(String id, String nombre, String descripcion, Date finalizacion, Estado estado, int complejidad) {
		super(id, nombre, descripcion, finalizacion, estado, complejidad);
		// TODO Auto-generated constructor stub
	}

}
