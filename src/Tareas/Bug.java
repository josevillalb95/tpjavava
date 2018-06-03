/**
 * 
 */
package Tareas;

import java.time.LocalDate;
import java.util.Date;

import com.sun.org.apache.bcel.internal.generic.LSUB;

import estadosTareas.Estado;

/**
 * @author tomi_
 *
 */
public class Bug extends Tarea{
	
	public Bug(String id, String nombre, String descripcion,EstadoTarea est, LocalDate finalizacion, int complejidad) {
		super(id, nombre, descripcion, est,finalizacion, complejidad);
		
	}
	/*public int calculaEstimacion(){
		int estimacion = 0;
		if(getLdependencias().first() != null)
			estimacion = (int) (getLdependencias().first().getComplejidad()*0.1 + 0.9);
		return getComplejidad() + estimacion;
		
	}*/
	public void agregarSubT(String idTarea){
		System.out.println("Bug no puede tener tareas");
	}
	public void agregarDep(Tarea tar){
		if(!getLdependencias().isEmpty())
			getLdependencias().add(tar);
		else
			System.out.println("Bug puede tener una sola dependencia");
	}
	public int estimacion(){
		double estimacion = 0;
		if(getLdependencias().first() != null)
			estimacion = getLdependencias().first().getComplejidad()*0.1;
		return (int)Math.ceil(getComplejidad() + estimacion);
	}
	
}
