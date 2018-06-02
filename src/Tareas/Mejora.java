/**
 * 
 */
package Tareas;

import java.time.LocalDate;
import java.util.Date;

import estadosTareas.Estado;

/**
 * @author tomi_
 *
 */
public class Mejora extends Tarea{
	
	public Mejora(String id, String nombre, String descripcion,EstadoTarea est, LocalDate finalizacion, int complejidad) {
		super(id, nombre, descripcion,est, finalizacion, complejidad);
		// TODO Auto-generated constructor stub
	}
	public double calculaEstimacion(){
		int estimacion= getEstimacion();
		int complejidad= getComplejidad();
		return estimacion * 0.5 + complejidad;
		
	}

}
