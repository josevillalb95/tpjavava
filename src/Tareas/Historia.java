/**
 * 
 */
package Tareas;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

import estadosTareas.Estado;

/**
 * @author tomi_
 *
 */
public class Historia extends Tarea implements Serializable{
	private ArrayList<DuplaFlujoPaso> ListaDuplafp ;
	private Map<String, Integer> flujoPasos = new HashMap<String, Integer>();
	
	public Historia(String id, String nombre, String descripcion,EstadoTarea est, LocalDate finalizacion, int complejidad) {
		super(id, nombre, descripcion, est,finalizacion, complejidad);
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
	
	public int estimacionPromedioDependencias(){
		TreeSet<Tarea>dependencias=new TreeSet<Tarea>();
		dependencias=getLdependencias();
		int est=0;
		int cont=0;
		Tarea t=null;
		if(!dependencias.isEmpty()){
			Iterator<Tarea>it=getLdependencias().iterator();
			while(it.hasNext()){
				t=it.next();
				est+=t.estimacion();
				cont++;
			}
		}
		if(cont!=0 && est!=0)
			return (int)est/cont;
		else
			return 0;
	}
	public double estimacionPromedioPasos(){
		int e=0;
		int cont=0;
		Iterator<Map.Entry<String, Integer>> map = flujoPasos.entrySet().iterator();
		while(map.hasNext()){
			Map.Entry<String, Integer> entry = map.next();
			e+=entry.getValue();
			cont++;
		}
		if(e!=0 && cont!=0)
			return 0.1*(e/cont);
		else
			return 0;
	}
	public int estimacion(){
		return (int)Math.ceil(getComplejidad()+estimacionPromedioDependencias()+estimacionPromedioPasos());
	}
	public void agregarDep(Tarea tar){
		String subString=tar.getId().substring(0, 3);
		if(subString.equals("TAR") || subString.equals("HIS"))
			getLdependencias().add(tar);
		else
			System.out.println("Las dependencias de historia pueden ser tareas o historias");
	}
	
	public void agregaFlujoPaso(String descripcion,int pasos){
		flujoPasos.put(descripcion, pasos);
	}
	
	public void muestra(){
		super.muestra();
		if(!flujoPasos.isEmpty()){
			System.out.println("Flujo pasos:");
			Iterator<Map.Entry<String, Integer>> map = flujoPasos.entrySet().iterator();
			while (map.hasNext()) {
				Map.Entry<String, Integer> entry = map.next();
				System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			}
		}
	}

}
