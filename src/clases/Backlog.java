/**
 * 
 */
package clases;

import java.util.Date;
import java.util.TreeSet;

import estadosTareas.Estado;

/**
 * @author tomi_
 *
 */
public class Backlog {
	
	private TreeSet<Tarea> LTareasP = new TreeSet<Tarea>();

	
	/**
	 * @param args
	 */
	public void agrega() {
		/*Tarea t= new Tarea("45Julia", null, null, null, 0);
		Tarea t2= new Tarea("45Maria", null, null, null, 0);
		Tarea t3= new Tarea("16Julia", null, null, null, 0);
		LTareasP = new TreeSet<Tarea>();
		LTareasP.add(t);
		LTareasP.add(t2);
		LTareasP.add(t3);*/
		
		for(Tarea lt : LTareasP) {
			System.out.println(lt.getId());
		}
	}

	

	
	public TreeSet<Tarea> getListaTB() {
		return LTareasP;
	}

	/**
	 * Permite agregar tareas a LTareasP
	 * @param tipo
	 * @param id
	 * @param nombre
	 * @param desc
	 * @param finalizacion
	 * @param comp
	 */
	public void altaTarea(String tipo, String id, String nombre, String desc, Date finalizacion, int comp){
		Tarea tar;
		switch (tipo){
			case "Bug":
				tar = new Bug(id,nombre,desc,finalizacion,comp);
				break;
			case "Historia":
				tar = new Historia(id,nombre,desc,finalizacion,comp);
				break;
			case "Mejora":
				tar = new Mejora(id,nombre,desc,finalizacion,comp);
				break;
			default:
				tar = null;
				break;	
		}
		LTareasP.add(tar);
	}
	

	/**
	 * 
	 * @param clave
	 * @param tare
	 * Modifica el valor de la clave del backglog.
	 * FALTA EL ESTADO :o !!! 
	 */
	
	public void mBacklogTarea(String clave , Tarea tare) {
		for(Tarea c:LTareasP ){
			if(c.getId().equals(clave)){
				if(c.getEstado() != "finalizado" )
					//c.modTarea(tare.getNombre(),tare.getDescripcion() ,tare.getfFin(), tare.getEstado(), tare.getComplejidad());
			c.getDescripcion();
			}
		}
	}
	/**
	 * 
	 * @param clave
	 * elimina un nodo del treeset que concida con la clave enviada 
	 */
	public void bSprintTarea(String clave , Tarea tare) {
		for(Tarea c:LTareasP ){
			if(c.getId().equals(clave)){
				LTareasP.remove(c); 
			}
		}
	}
	
	

	

}