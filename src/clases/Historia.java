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
	private ArrayList<DuplaFlujoPaso> ListaDuplafp ;
	
	public Historia(String id, String nombre, String descripcion, Date finalizacion, int complejidad) {
		super(id, nombre, descripcion, finalizacion, complejidad);
		ListaDuplafp = new ArrayList<DuplaFlujoPaso>();
		
		// TODO Auto-generated constructor stub
	}
	
	public int calculaEstimacion(){
		int promEstimacion=0;
		int estimacion=0;
		if(getLdependencias().first() != null)	
			for(Tarea t:getLdependencias()){
				promEstimacion += t.getEstimacion();
			}
			promEstimacion/= getLdependencias().size();
			
			estimacion = (int) (getLdependencias().first().getComplejidad()*0.1 + 0.9);
		return getComplejidad() + estimacion  ;
		
	}

}
