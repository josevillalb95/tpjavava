/**
 * 
 */
package clases;

import java.util.ArrayList;
import java.util.Date;

import estadosTareas.Estado;

/**
 * @author tomi_
 *
 */
public class Historia extends Tarea{
	
	private ArrayList<Historia> dependencias; 
	//Dupla flujo paso = otra clase? O hacerlo como dos arreglos?

	public Historia(String id, String nombre, String descripcion, Date finalizacion, Estado estado, int complejidad) {
		super(id, nombre, descripcion, finalizacion, estado, complejidad);
		// TODO Auto-generated constructor stub
	}

}