/**
 * 
 */
package Tareas;

import java.util.Date;

import com.sun.org.apache.bcel.internal.generic.LSUB;

import estadosTareas.Estado;

/**
 * @author tomi_
 *
 */
public class Bug extends Tarea{
	
	public Bug(String id, String nombre, String descripcion, Date finalizacion, int complejidad) {
		super(id, nombre, descripcion, finalizacion, complejidad);
		
	}
	public int calculaEstimacion(){
		int estimacion = 0;
		if(getLdependencias().first() != null)
			estimacion = (int) (getLdependencias().first().getComplejidad()*0.1 + 0.9);
		return getComplejidad() + estimacion;
		
	}
	
}
